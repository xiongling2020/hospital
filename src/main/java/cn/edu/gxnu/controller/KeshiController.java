package cn.edu.gxnu.controller;

import cn.edu.gxnu.bean.Keshi;
import cn.edu.gxnu.service.IKeshiService;
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

@RequestMapping("/keshi")
@Controller
public class KeshiController {
    @Autowired
    IKeshiService keshiService;

    @RequestMapping(value = "/getKeshi")
    public @ResponseBody
    PageInfo<Keshi> getKeshi(Model model, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Keshi> keshiList=keshiService.getKeshi();
        System.out.println("keshiList size     :" + keshiList.size());
        PageInfo<Keshi> pageInfo=new PageInfo<Keshi>(keshiList,pageSize);
        model.addAttribute("keshiList",keshiList);
        model.addAttribute("pageInfo",pageInfo);
        return pageInfo;
    }

    /*先查询到数据存放在session作用域中，之后再取出来并显示*/
    @RequestMapping(value = "/viewKeshi")
    public String viewDoctor(){
        return "redirect:/viewKeshi.html";
    }

    @RequestMapping(value = "/addKeshi",method = RequestMethod.POST)
    public @ResponseBody String addKeshi(String keshiName,Integer keshiRenShu,String keshiFuZheRen){
        Keshi keshi=new Keshi();
        keshi.setKeshiName(keshiName);
        keshi.setKeshiFuZheRen(keshiFuZheRen);
        keshi.setKeshiRenShu(keshiRenShu);
        keshi.setKeshiId(UUID.randomUUID().toString().replace("-",""));
        keshiService.addKeshi(keshi);
        return "addOK";
    }

    @RequestMapping(value = "/lookUpKeshi",method = RequestMethod.POST)
    public @ResponseBody Keshi lookUpKeshi(String keshiId, HttpSession session){
        System.out.println("keshiId" + keshiId);
        Keshi keshi=keshiService.lookUpKeshi(keshiId);
        System.out.println("keshi" + keshi);
        return keshi;
    }

    @RequestMapping(value="/deleteKeshi")
    public @ResponseBody String deleteKeshi(String keshiId){
        keshiService.deleteKeshi(keshiId);
        return "deleteOK";
    }

    @RequestMapping(value="/updateKeshi")
    public @ResponseBody String updateKeshi(String keshiId,String keshiName, Integer keshiRenShu,String keshiFuZheRen){
        Keshi keshi=new Keshi();
        keshi.setKeshiId(keshiId);
        keshi.setKeshiName(keshiName);
        keshi.setKeshiRenShu(keshiRenShu);
        keshi.setKeshiFuZheRen(keshiFuZheRen);
        keshiService.updateKeshi(keshi);
        return "updateOK";
    }

    @RequestMapping(value = "/selectKeshi",method = RequestMethod.POST)
    public @ResponseBody Keshi selectKeshi(String keshiName, HttpSession session){
        System.out.println("科室名称: "+keshiName);
        Keshi keshi=keshiService.selectKeshi(keshiName);
        session.setAttribute("keshi",keshi);
        if(keshi!=null){
            System.out.println(keshi);
            return keshi;
        }else{
            System.out.println("该科室不存在");
            return null;
        }
    }
}
