package cn.edu.gxnu.controller;


import cn.edu.gxnu.bean.Manager;
import cn.edu.gxnu.bean.Permission;
import cn.edu.gxnu.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/manager")/*请求映射*/
@Controller/*控制器：注入服务，声明Action组件*/
public class ManagerController {

    @Autowired /*注入  它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。
                通过 @Autowired的使用来消除 set ，get方法。*/
    IManagerService managerService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String managerLoginName, String managerPassword, HttpSession session){
        System.out.println("用户名: "+managerLoginName);
        System.out.println("密码: "+managerPassword);
        Manager manager=managerService.login(managerLoginName,managerPassword);
        session.setAttribute("manager",manager);/*将信息存在session作用域中，以便后面获取*/
        if(manager!=null){
            return "redirect:/managerIndex.html";
        }else{
            return "redirect:/login.html";
        }
    }

    /*从session作用域中取到登录者信息，即先获得管理员信息，后面根据管理员id获取角色id，再根据角色id与用户id获取权限*/
    @RequestMapping("/getManagerInfo")
    public @ResponseBody Manager getManagerInfo(HttpSession session){
        Manager manager=(Manager)session.getAttribute("manager");
        return manager;
    }

    /*@ResponseBody的作用是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，
    写入到response对象的body区，通常用来返回JSON数据或者是XML数据，需要注意，在使用此注解之后不会再走试图处理器，
    而是直接将数据写入到输入流中，他的效果等同于通过response对象输出指定格式的数据。*/
    @RequestMapping(value = "/getManagerPermission")
    public @ResponseBody List getManagerPermission(String rolesId, String managerId){
        List<Permission> permissionList=managerService.getManagerPermission(rolesId,managerId);
        System.out.println("权限：" + permissionList.size());
        return  permissionList;
    }

    @RequestMapping(value = "/viewManagerOwn")
    public String viewOwn(){
        return "redirect:/viewManagerOwn.html";
    }

    @RequestMapping(value = "/selectOwn")
    public @ResponseBody Manager selectOwn(String managerId){
        System.out.println("managerId:   " + managerId);
        Manager manager=managerService.selectOwn(managerId);
        return manager;
    }


    @RequestMapping(value="/updateOwn")
    @ResponseBody
    public String updateOwn(String managerId,String managerName,String managerLoginName,Integer managerAge,String managerPhone,String managerTitle){
        Manager manager=new Manager();
        manager.setManagerId(managerId);
        manager.setManagerName(managerName);
        manager.setManagerLoginName(managerLoginName);
        manager.setManagerPhone(managerPhone);
        manager.setManagerTitle(managerTitle);
        manager.setManagerAge(managerAge);
        managerService.updateOwn(manager);
        return "updateOK";
    }

    @RequestMapping(value = "/updateManagerOwn")
    public String updateManagerOwn(){
        return "redirect:/updateManagerOwn.html";
    }

    @RequestMapping(value = "/changeManagerPassword")
    public String changeManagerPassword(){
        return "redirect:/changeManagerPassword.html";
    }

    @RequestMapping(value = "/changePwd",produces = {"application/json;charset=utf-8"})
    public @ResponseBody Object changePwd(String managerId,String managerPassword, String oldPassword, String newPassword, String snewPassword) {
        Manager manager=new Manager();
        Map<String,Object> map=new HashMap<>();/*创建Map对象 Object是所有类型的父类*/
        if ((managerPassword.equals(oldPassword)) && (newPassword.equals(snewPassword)) && (oldPassword!="")&&(newPassword!="")) {
            manager.setManagerId(managerId);
            manager.setManagerPassword(newPassword);
            managerService.changePwd(manager);
            System.out.println("managerId:    " + manager.getManagerId());
            System.out.println("password:    " + manager.getManagerPassword());
            map.put("msg","changeOK");/*存储key和value*/
        } else {
            if (!managerPassword.equals(oldPassword)) {
                map.put("msg","jiucuo");
            }
            if (!newPassword.equals(snewPassword)) {
                map.put("msg","buyizhi");
            }
            if(oldPassword==""){
                map.put("msg","jiukong");
            }
            if(snewPassword==""){
                map.put("msg","quekong");
            }
            if(newPassword==""){
                map.put("msg","xinkong");
            }
        }
        System.out.println("map:   " + map);
        return map;
    }

}
