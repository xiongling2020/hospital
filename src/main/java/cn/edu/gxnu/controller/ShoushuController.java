package cn.edu.gxnu.controller;

import cn.edu.gxnu.bean.ShouShu;
import cn.edu.gxnu.service.IShoushuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RequestMapping("/shoushu")
@Controller
public class ShoushuController {
    @Autowired
    IShoushuService shoushuService;

    @RequestMapping(value = "/getShoushu")
    public @ResponseBody PageInfo<ShouShu> getShoushu(Model model, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                      @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<ShouShu> shouShuList=shoushuService.getShoushu();
        System.out.println("shouShuList:  " +shouShuList);
        PageInfo<ShouShu> pageInfo=new PageInfo<ShouShu>(shouShuList,pageSize);
        model.addAttribute("shouShuList",shouShuList);
        model.addAttribute("pageInfo",pageInfo);
        return pageInfo;
    }

    /*先查询到数据存放在session作用域中，之后再取出来并显示*/
    @RequestMapping(value = "/viewShoushu")
    public String viewShoushu(){
        return "redirect:/viewShoushu.html";
    }

    @RequestMapping(value = "/addShoushu",method = RequestMethod.POST)
    public @ResponseBody String addShoushu(String shoushushi,String doctorId, String doctorName,String bingfangId,
                                           String patientId,String patientName, String startTime,String overTime,
                                           String hushiId,String hushiName,String guimo,String xingzhi){
        ShouShu shouShu=new ShouShu();
        shouShu.setBingfangId(bingfangId);
        shouShu.setDoctorId(doctorId);
        shouShu.setDoctorName(doctorName);
        shouShu.setShoushushi(shoushushi);
        shouShu.setPatientId(patientId);
        shouShu.setPatientName(patientName);
        shouShu.setHushiId(hushiId);
        shouShu.setHushiName(hushiName);
        shouShu.setGuimo(guimo);
        shouShu.setXingzhi(xingzhi);

        /*以下为String转Datetime保存数据到数据库中*/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        sdf.setLenient(false);
        Date date1= new Date();
        Date date2= new Date();
        try {
            /*SimpleDateFormat中的parse方法可以把String型的字符串转换成特定格式的date类型
             format方法可以把Date型的字符串转换成特定格式的String类型*/
            date1 = sdf.parse(startTime);
            date2 = sdf.parse(overTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Timestamp timestamp1=new java.sql.Timestamp(date1.getTime());
        java.sql.Timestamp timestamp2=new java.sql.Timestamp(date2.getTime());
        shouShu.setStartTime(timestamp1);
        shouShu.setOverTime(timestamp2);
        shouShu.setShoushuId(UUID.randomUUID().toString().replace("-",""));
        shoushuService.addShoushu(shouShu);
       /* System.out.println("aaaaa: " + shouShu.getShoushuId());
        System.out.println("bbbbb: " + shouShu.getStartTime());
        System.out.println("ccccc: " + shouShu.getOverTime());*/
        return "addOK";
    }

    @RequestMapping(value="/deleteShoushu")
    public @ResponseBody String deleteShoushu(String shoushuId){
       shoushuService.deleteShoushu(shoushuId);
        return "deleteOK";
    }

    @RequestMapping(value="/updateShoushu")
    public @ResponseBody String updateShoushu(String shoushuId, String startTime,String overTime,String shoushushi){
        ShouShu shouShu=new ShouShu();
        shouShu.setShoushuId(shoushuId);
        shouShu.setShoushushi(shoushushi);
        /*以下为String 转Date保存数据到数据库中*/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        Date date1= null;
        Date date2= null;
        try {
            date1 = sdf.parse(startTime);
            date2 = sdf.parse(overTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        shouShu.setStartTime(new java.sql.Timestamp(date1.getTime()));
        shouShu.setOverTime(new java.sql.Timestamp(date2.getTime()));
        shoushuService.updateShoushu(shouShu);
        return "updateOK";
    }

    @RequestMapping(value = "/selectShoushu",method = RequestMethod.POST)
    public @ResponseBody ShouShu selectShoushu(String shoushuId, HttpSession session){
        System.out.println("shoushuId: "+shoushuId);
        ShouShu shoushu=shoushuService.selectShoushu(shoushuId);
        session.setAttribute("shoushu",shoushu);
        if(shoushu!=null){
            System.out.println(shoushu);
            return shoushu;
        }else{
            return null;
        }
    }

    @RequestMapping(value = "/doctorSelectShoushu",method = RequestMethod.POST)
    public @ResponseBody ShouShu doctorSelectShoushu(String shoushuId,String doctorId, HttpSession session){
        ShouShu shouShu=shoushuService.doctorSelectShoushu(shoushuId,doctorId);
        session.setAttribute("shouShu",shouShu);
        if(shouShu!=null){
            System.out.println(shouShu);
            return shouShu;
        }else{
            return null;
        }
    }

    @RequestMapping(value = "/hushiSelectShoushu",method = RequestMethod.POST)
    public @ResponseBody ShouShu hushiSelectShoushu(String shoushuId,String hushiId, HttpSession session){
        ShouShu shouShu=shoushuService.hushiSelectShoushu(shoushuId,hushiId);
        session.setAttribute("shouShu",shouShu);
        if(shouShu!=null){
            System.out.println(shouShu);
            return shouShu;
        }else{
            return null;
        }
    }


    /*护士查看手术信息*/
    @RequestMapping(value = "/doctorAndHushiViewAllShoushu")
    public String viewShoushuInfo(){
        return "redirect:/doctorAndHushiViewAllShoushu.html";
    }

    @RequestMapping(value = "/doctorViewOwnShoushu")
    public String doctorViewOwnShoushu(){
        return "redirect:/doctorViewOwnShoushu.html";
    }

    @RequestMapping(value = "/doctorViewShoushu")
    public @ResponseBody PageInfo<ShouShu> doctorViewShoushu(String doctorName,String doctorId,Model model, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                             @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<ShouShu> shouShuList=shoushuService.doctorViewShoushu(doctorId,doctorName);
        System.out.println("date:  " + shouShuList);
        PageInfo<ShouShu> pageInfo=new PageInfo<ShouShu>(shouShuList,pageSize);
        model.addAttribute("shouShuList",shouShuList);
        model.addAttribute("pageInfo",pageInfo);
        return pageInfo;
    }



    @RequestMapping(value = "/hushiViewOwnShoushu")
    public String hushiViewOwnShoushu(){
        return "redirect:/hushiViewOwnShoushu.html";
    }

    @RequestMapping(value = "/hushiViewShoushu")
    public @ResponseBody PageInfo<ShouShu> hushiViewShoushu(String hushiName,String hushiId,Model model, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                             @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<ShouShu> shouShuList=shoushuService.hushiViewShoushu(hushiId,hushiName);
        System.out.println("date:  " + shouShuList);
        PageInfo<ShouShu> pageInfo=new PageInfo<ShouShu>(shouShuList,pageSize);
        model.addAttribute("shouShuList",shouShuList);
        model.addAttribute("pageInfo",pageInfo);
        return pageInfo;
    }
}
