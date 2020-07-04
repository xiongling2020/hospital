package cn.edu.gxnu.controller;

import cn.edu.gxnu.bean.Doctor;
import cn.edu.gxnu.bean.Permission;
import cn.edu.gxnu.service.IDoctorService;
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

@RequestMapping("/doctor")
@Controller
public class DoctorController {

    @Autowired/*注入  它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。
                通过 @Autowired的使用来消除 set ，get方法。*/
    IDoctorService doctorService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String doctorLoginName, String doctorPassword, HttpSession session){
        /*System.out.println("用户名: "+doctorLoginName);
        System.out.println("密码: "+doctorPassword);*/
        Doctor doctor=doctorService.login(doctorLoginName,doctorPassword);
        session.setAttribute("doctor",doctor);
        if(doctor!=null){
            return "redirect:/doctorIndex.html";
        }else{
            return "redirect:/login.html";
        }
    }

    /*该数据是直接从login环节中的session缓存中取得*/
    @RequestMapping("/getDoctorInfo")
    public @ResponseBody Doctor getDoctorInfo(HttpSession session){
        Doctor doctor= (Doctor) session.getAttribute("doctor");
        return doctor;
    }

    @RequestMapping(value = "/getDoctorPermission")
    public @ResponseBody List getDoctorPermission(String rolesId, String doctorId){
        /*System.out.println("医生id："+rolesId);
        System.out.println("医生id："+doctorId);*/
        List<Permission> permissionList=doctorService.getDoctorPermission(rolesId,doctorId);
        return permissionList;
    }

    @RequestMapping(value = "/getDoctor")
    public @ResponseBody PageInfo<Doctor> getDoctor(Model model, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Doctor> doctorList=doctorService.getDoctor();
        System.out.println("doctorList size     :" + doctorList.size());
        PageInfo<Doctor> pageInfo=new PageInfo<Doctor>(doctorList,pageSize);
        model.addAttribute("doctorList",doctorList);
        model.addAttribute("pageInfo",pageInfo);
        /*System.out.println("pageInfo111111     :" + pageInfo.getList());*/
        return pageInfo;
    }

    /*先查询到数据存放在session作用域中，之后再取出来并显示*/
    @RequestMapping(value = "/viewDoctor")
    public String viewDoctor(){
        return "redirect:/viewDoctor.html";
    }

    @RequestMapping(value = "/addDoctor",method = RequestMethod.POST)
    public @ResponseBody String addDoctor(String doctorName,String doctorLoginName,String doctorPassword,
                                          String doctorSex,Integer doctorAge,String doctorKeshi,
                                          String doctorTitle,String doctorPhone){
        Doctor doctor=new Doctor();
        doctor.setDoctorName(doctorName);
        doctor.setDoctorLoginName(doctorLoginName);
        doctor.setDoctorPassword(doctorPassword);
        doctor.setDoctorSex(doctorSex);
        doctor.setDoctorAge(doctorAge);
        doctor.setDoctorKeshi(doctorKeshi);
        doctor.setDoctorPhone(doctorPhone);
        doctor.setDoctorTitle(doctorTitle);
        doctor.setDoctorId(UUID.randomUUID().toString().replace("-",""));
        doctorService.addDoctor(doctor);
        return "addOK";
    }

    @RequestMapping(value="/deleteDoctor")
    public @ResponseBody String deleteDoctor(String doctorId){
        doctorService.deleteDoctor(doctorId);
        return "deleteOK";
    }

    @RequestMapping(value="/updateDoctor")
    public @ResponseBody String updateDoctor(String doctorId,String doctorName,String doctorLoginName,
                                             String doctorPassword, Integer doctorAge,String doctorKeshi,
                                             String doctorTitle,String doctorPhone){
        Doctor doctor=new Doctor();
        doctor.setDoctorId(doctorId);
        doctor.setDoctorName(doctorName);
        doctor.setDoctorLoginName(doctorLoginName);
        doctor.setDoctorPassword(doctorPassword);
        doctor.setDoctorAge(doctorAge);
        doctor.setDoctorKeshi(doctorKeshi);
        doctor.setDoctorTitle(doctorTitle);
        doctor.setDoctorPhone(doctorPhone);
        doctorService.updateDoctor(doctor);
        return "updateOK";
    }

    @RequestMapping(value = "/lookUpDoctor",method = RequestMethod.POST)
    public @ResponseBody Doctor lookUpDoctor(String doctorId, HttpSession session){
        System.out.println("doctorId" + doctorId);
        Doctor doctor=doctorService.lookUpDoctor(doctorId);
        System.out.println("doctor" + doctor);
        return doctor;
    }

    @RequestMapping(value = "/selectDoctor",method = RequestMethod.POST)
    public @ResponseBody Doctor selectDoctor(String doctorName, HttpSession session){
        System.out.println("医生的名字: "+doctorName);
        Doctor doctor=doctorService.selectDoctor(doctorName);
        session.setAttribute("doctor",doctor);
        if(doctor!=null){
            System.out.println(doctor);
            return doctor;
        }else{
            System.out.println("该用户不存在");
            return null;
        }
    }

    @RequestMapping(value = "/viewDoctorOwn")
    public String viewDoctorOwn(){
        return "redirect:/viewDoctorOwn.html";
    }

    @RequestMapping(value = "/selectOwn")
    public @ResponseBody Doctor selectOwn(String doctorId){
        System.out.println("doctorId:   " + doctorId);
        Doctor doctor=doctorService.selectOwn(doctorId);
        return doctor;
    }

    @RequestMapping(value="/updateOwn")
    public @ResponseBody String updateOwn(String doctorId,String doctorName,String doctorLoginName,
                                          Integer doctorAge,String doctorKeshi,String doctorTitle,
                                          String doctorPhone){
        Doctor doctor=new Doctor();
        doctor.setDoctorId(doctorId);
        doctor.setDoctorName(doctorName);
        doctor.setDoctorLoginName(doctorLoginName);
        doctor.setDoctorAge(doctorAge);
        doctor.setDoctorKeshi(doctorKeshi);
        doctor.setDoctorTitle(doctorTitle);
        doctor.setDoctorPhone(doctorPhone);
        doctorService.updateOwn(doctor);
        return "updateOK";
    }

    @RequestMapping(value = "/updateDoctorOwn")
    public String updateDoctorOwn(){
        return "redirect:/updateDoctorOwn.html";
    }

    @RequestMapping(value = "/changeDoctorPassword")
    public String changeManagerPassword(){
        return "redirect:/changeDoctorPassword.html";
    }

    @RequestMapping(value = "/changePassword",produces = {"application/json;charset=utf-8"})
    public @ResponseBody Object changePassword(String doctorId,String doctorPassword, String oldPassword,
                                               String newPassword, String snewPassword) {
        Doctor doctor=new Doctor();
        Map<String,Object> map=new HashMap<>();
        if ((doctorPassword.equals(oldPassword)) && (newPassword.equals(snewPassword)) && (oldPassword!="")
                                                 &&(newPassword!="")) {
            doctor.setDoctorId(doctorId);
            doctor.setDoctorPassword(newPassword);
            doctorService.changePassword(doctor);
            map.put("msg","changeOK");
        } else {
            if (!doctorPassword.equals(oldPassword)) {
                map.put("msg","jiucuo");
            }
            if (!newPassword.equals(snewPassword)) {
                map.put("msg","buyizhi");
            }
            if(oldPassword==""){
                map.put("msg","jiukong");
            }
            if(newPassword==""){
                map.put("msg","xinkong");
            }
            if(snewPassword==""){
                map.put("msg","quekong");
            }
        }
        System.out.println("map:   " + map);
        return map;
    }


}
