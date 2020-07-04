package cn.edu.gxnu.controller;

import cn.edu.gxnu.bean.Bingfang;
import cn.edu.gxnu.service.IBingfangService;
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
import java.util.List;
import java.util.UUID;

@RequestMapping("/bingfang")
@Controller
public class BingfangController {
    @Autowired
    IBingfangService bingfangService;

    @RequestMapping(value = "/getBingfang")
    public @ResponseBody
    PageInfo<Bingfang> getBingfang(Model model, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Bingfang> bingfangList=bingfangService.getBingfang();
        System.out.println(" bingfangList size     :" +  bingfangList.size());
        PageInfo<Bingfang> pageInfo=new PageInfo<Bingfang>( bingfangList,pageSize);
        model.addAttribute(" bingfangList", bingfangList);
        model.addAttribute("pageInfo",pageInfo);
        return pageInfo;
    }

    /*先查询到数据存放在session作用域中，之后再取出来并显示*/
    @RequestMapping(value = "/viewBingfang")
    public String viewDoctor(){
        return "redirect:/viewBingfang.html";
    }

    @RequestMapping(value = "/addBingfang",method = RequestMethod.POST)
    public @ResponseBody String addBingfang(String bingfangNo,String keshiId,String keshiName,Integer zongchuangshu,Integer kongchuangshu,Integer price){
        Bingfang bingfang=new Bingfang();
        bingfang.setBingfangNo(bingfangNo);
        bingfang.setKeshiId(keshiId);
        bingfang.setKeshiName(keshiName);
        bingfang.setZongchuangshu(zongchuangshu);
        bingfang.setKongchuangshu(kongchuangshu);
        bingfang.setPrice(price);
        bingfang.setBingfangId(UUID.randomUUID().toString().replace("-",""));
        bingfangService.addBingfang(bingfang);
        return "addOK";
    }

    @RequestMapping(value="/deleteBingfang")
    public @ResponseBody String deleteBingfang(String bingfangId){
        bingfangService.deleteBingfang(bingfangId);
        return "deleteOK";
    }

    @RequestMapping(value="/updateBingfang")
    public @ResponseBody String updateBingfang(String bingfangId,Integer zongchuangshu,Integer kongchuangshu,Integer price){
        Bingfang bingfang=new Bingfang();
        bingfang.setBingfangId(bingfangId);
        bingfang.setZongchuangshu(zongchuangshu);
        bingfang.setKongchuangshu(kongchuangshu);
        bingfang.setPrice(price);
        bingfangService.updateBingfang(bingfang);
        return "updateOK";
    }

    @RequestMapping(value = "/selectBingfang",method = RequestMethod.POST)
    public @ResponseBody Bingfang selectBingfang(String bingfangId, HttpSession session){
        System.out.println("病房ID: "+bingfangId);
        Bingfang bingfang=bingfangService.selectBingfang(bingfangId);
        session.setAttribute("bingfang",bingfang);
        if(bingfang!=null){
            System.out.println(bingfang);
            return bingfang;
        }else{
            System.out.println("该病房不存在");
            return null;
        }
    }
}
