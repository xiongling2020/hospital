package cn.edu.gxnu.controller;

import cn.edu.gxnu.bean.Hushi;
import cn.edu.gxnu.bean.Permission;
import cn.edu.gxnu.service.IHushiService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequestMapping("/hushi")
@Controller
public class HushiController {

    @Autowired
    IHushiService hushiService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String hushiLoginName, String hushiPassword, HttpSession session){
        System.out.println("用户名: "+hushiLoginName);
        System.out.println("密码: "+hushiPassword);
        Hushi hushi=hushiService.login(hushiLoginName,hushiPassword);
        session.setAttribute("hushi",hushi);
        if(hushi!=null){
            return "redirect:/hushiIndex.html";
        }else{
            return "redirect:/login.html";
        }
    }

    @RequestMapping("/getHushiInfo")
    public @ResponseBody Hushi getUserInfo(HttpSession session){
        Hushi hushi= (Hushi) session.getAttribute("hushi");
        return hushi;
    }

    @RequestMapping(value = "/getHushiPermission")
    public @ResponseBody List getHushiPermission( String rolesId, String hushiId){
        System.out.println("护士id："+rolesId);
        System.out.println("护士id："+hushiId);
        List<Permission> permissionList=hushiService.getHushiPermission(rolesId,hushiId);
        return permissionList;
    }

    @RequestMapping("/getHushi")
    public @ResponseBody PageInfo<Hushi> getHushi(Model model,@RequestParam(value="pageNum",defaultValue="1")Integer pageNum,
                                                  @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Hushi> hushiList=hushiService.getHushi();
        System.out.println("hushiList size:    " + hushiList.size());
        PageInfo<Hushi> pageInfo = new PageInfo<Hushi>(hushiList,pageSize);
        model.addAttribute("hushiList",hushiList);
        model.addAttribute("pageInfo",pageInfo);
        return pageInfo;
    }

    @RequestMapping(value = "/viewHushi")
    public String viewHushi(){
        return "redirect:/viewHushi.html";
    }

    @RequestMapping(value = "/addHushi",method = RequestMethod.POST)
    public @ResponseBody String addHushi(String hushiName,String hushiLoginName,String hushiPassword, String hushiSex,Integer hushiAge,String hushiTitle,String hushiPhone){
        Hushi hushi=new Hushi();
        hushi.setHushiId(UUID.randomUUID().toString().replace("-",""));
        hushi.setHushiName(hushiName);
        hushi.setHushiLoginName(hushiLoginName);
        hushi.setHushiPassword(hushiPassword);
        hushi.setHushiAge(hushiAge);
        hushi.setHushiSex(hushiSex);
        hushi.setHushiTitle(hushiTitle);
        hushi.setHushiPhone(hushiPhone);
        hushiService.addHushi(hushi);
        return "addOK";
    }

    @RequestMapping(value="/deleteHushi")
    public @ResponseBody String deleteHushi(String hushiId){
        hushiService.deleteHushi(hushiId);
        return "deleteOK";
    }

    @RequestMapping(value="/updateHushi")
    public @ResponseBody String updateHushi(String hushiId,String hushiName,String hushiLoginName, String hushiPassword, Integer hushiAge,String hushiTitle,String hushiPhone){
        Hushi hushi=new Hushi();
        hushi.setHushiId(hushiId);
        hushi.setHushiName(hushiName);
        hushi.setHushiLoginName(hushiLoginName);
        hushi.setHushiPassword(hushiPassword);
        hushi.setHushiAge(hushiAge);
        hushi.setHushiTitle(hushiTitle);
        hushi.setHushiPhone(hushiPhone);
        hushiService.updateHushi(hushi);
        return "updateOK";
    }

    @RequestMapping(value = "/lookUpHushi",method = RequestMethod.POST)
    public @ResponseBody Hushi lookUpHushi(String hushiId, HttpSession session){
        System.out.println("hushiId" + hushiId);
        Hushi hushi=hushiService.lookUpHushi(hushiId);
        System.out.println("hushi" + hushi);
        return hushi;
    }

    @RequestMapping(value = "/selectHushi",method = RequestMethod.POST)
    public @ResponseBody Hushi selectHushi(String hushiName, HttpSession session){
        System.out.println("hushiname: "+hushiName);
        Hushi hushi=hushiService.selectHushi(hushiName);
        session.setAttribute("hushi",hushi);
        if(hushi!=null){
            System.out.println(hushi);
            return hushi;
        }else{
            return null;
        }
    }

    @RequestMapping(value = "/viewHushiOwn")
    public String viewHushiOwn(){
        return "redirect:/viewHushiOwn.html";
    }

    @RequestMapping(value = "/selectOwn")
    public @ResponseBody Hushi selectOwn(String hushiId){
        System.out.println("hushiId:   " + hushiId);
        Hushi hushi=hushiService.selectOwn(hushiId);
        return hushi;
    }

    @RequestMapping(value="/updateOwn")
    public @ResponseBody String updateOwn(String hushiId,String hushiName,String hushiLoginName, Integer hushiAge,String hushiTitle,String hushiPhone){
        Hushi hushi=new Hushi();
        hushi.setHushiId(hushiId);
        hushi.setHushiName(hushiName);
        hushi.setHushiLoginName(hushiLoginName);
        hushi.setHushiAge(hushiAge);
        hushi.setHushiTitle(hushiTitle);
        hushi.setHushiPhone(hushiPhone);
        hushiService.updateOwn(hushi);
        return "updateOK";
    }

    @RequestMapping(value = "/updateHushiOwn")
    public String updateHushiOwn(){
        return "redirect:/updateHushiOwn.html";
    }

    @RequestMapping(value = "/changeHushiPassword")
    public String changeManagerPassword(){
        return "redirect:/changeHushiPassword.html";
    }

    @RequestMapping(value = "/changePassword",produces = {"application/json;charset=utf-8"})
    public @ResponseBody Object changePassword(String hushiId,String hushiPassword, String oldPassword, String newPassword, String snewPassword) {
        Hushi hushi=new Hushi();
        Map<String,Object> map=new HashMap<>();
        if ((hushiPassword.equals(oldPassword)) && (newPassword.equals(snewPassword)) && (oldPassword!="")&&(newPassword!="")) {
            hushi.setHushiId(hushiId);
            hushi.setHushiPassword(newPassword);
            hushiService.changePassword(hushi);
            map.put("msg","changeOk");
        } else {
            if (!hushiPassword.equals(oldPassword)) {
                map.put("msg","jiucuo");
            }
            if (!newPassword.equals(snewPassword)) {
                map.put("msg","buyizhi");
            }
            if(snewPassword==""){
                map.put("msg","quekong");
            }
            if(oldPassword==""){
                map.put("msg","jiukong");
            }
            if(newPassword==""){
                map.put("msg","xinkong");
            }
        }
        System.out.println("map:   " + map);
        return map;
    }

}
