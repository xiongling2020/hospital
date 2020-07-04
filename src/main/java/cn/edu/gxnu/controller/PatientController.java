package cn.edu.gxnu.controller;

import cn.edu.gxnu.bean.Patient;
import cn.edu.gxnu.service.IPatientService;
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

@RequestMapping("/patient")
@Controller
public class PatientController {
    @Autowired
    IPatientService patientService;
    @RequestMapping(value = "/getPatient")
    public @ResponseBody PageInfo<Patient> getPatient(Model model, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                     @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Patient> patientList=patientService.getPatient();
        System.out.println("date:  " + patientList);
        PageInfo<Patient> pageInfo=new PageInfo<Patient>(patientList,pageSize);
        model.addAttribute("patientList",patientList);
        model.addAttribute("pageInfo",pageInfo);
        return pageInfo;
    }

    /*先查询到数据存放在session作用域中，之后再取出来并显示*/
    @RequestMapping(value = "/viewPatient")
    public String viewPatient(){
        return "redirect:/viewPatient.html";
    }

    @RequestMapping(value = "/addPatient",method = RequestMethod.POST)
    public @ResponseBody String addPatient(String patientName, String patientSex, Integer patientAge, String phone, String zhuYuanRiQi,
                                           String chuYuanRiQi, String zhengZhuang,String doctorName,String doctorId,
                                           String hushiName,String hushiId,String bingfangNo,String bingchuangNo,
                                           String address,String guomin,String yizhu,String chafangshijian,
                                           String dazhenshijian,String medicine,String shoushushijian){
        Patient patient=new Patient();
        patient.setPatientName(patientName);
        patient.setPatientSex(patientSex);
        patient.setPatientAge(patientAge);
        patient.setPhone(phone);
        patient.setDoctorName(doctorName);
        patient.setDoctorId(doctorId);
        patient.setHushiId(hushiId);
        patient.setHushiName(hushiName);
        patient.setBingfangNo(bingfangNo);
        patient.setBingchuangNo(bingchuangNo);
        patient.setAddress(address);
        patient.setGuomin(guomin);
        patient.setYizhu(yizhu);
        patient.setChafangshijian(chafangshijian);
        patient.setDazhenshijian(dazhenshijian);
        patient.setMedicine(medicine);
        /*以下为String 转Date保存数据到数据库中*/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        Date date1= null;
        Date date2= null;
        Date date3= null;
        try {
            date3=sdf1.parse(shoushushijian);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            date1 = sdf.parse(zhuYuanRiQi);
            date2 = sdf.parse(chuYuanRiQi);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        patient.setZhuYuanRiQi(new java.sql.Date(date1.getTime()));
        patient.setChuYuanRiQi(new java.sql.Date(date2.getTime()));
        patient.setShoushushijian(new java.sql.Timestamp(date3.getTime()));
        patient.setZhengZhuang(zhengZhuang);
        patient.setPatientId(UUID.randomUUID().toString().replace("-",""));
        patientService.addPatient(patient);
        return "addOK";
    }

    @RequestMapping(value="/deletePatient")
    public @ResponseBody String deletePatient(String patientId){
        patientService.deletePatient(patientId);
        return "deleteOK";
    }

    @RequestMapping(value = "/lookUpPatient",method = RequestMethod.POST)
    public @ResponseBody Patient lookUpPatient(String patientId, HttpSession session){
        System.out.println("patientId" + patientId);
        Patient patient=patientService.lookUpPatient(patientId);
        System.out.println("patient" + patient);
        return patient;
    }

    @RequestMapping(value="/updatePatient")
    public @ResponseBody String updatePatient(String patientId, Integer patientAge,String zhuYuanRiQi,String chuYuanRiQi,
                                              String phone,String bingchuangNo,String bingfangNo,String shoushushijian){
        Patient patient=new Patient();
        patient.setPatientId(patientId);
        patient.setPatientAge(patientAge);
        patient.setPhone(phone);
        patient.setBingfangNo(bingfangNo);
        patient.setBingchuangNo(bingchuangNo);

        /*以下为String 转Date保存数据到数据库中*/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        Date date1= null;
        Date date2= null;
        Date date3= null;
        try {
            date1 = sdf.parse(zhuYuanRiQi);
            date2 = sdf.parse(chuYuanRiQi);
            date3=sdf1.parse(shoushushijian);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        patient.setZhuYuanRiQi(new java.sql.Date(date1.getTime()));
        patient.setChuYuanRiQi(new java.sql.Date(date2.getTime()));
        patient.setShoushushijian(new java.sql.Timestamp(date3.getTime()));
        patientService.updatePatient(patient);
        return "updateOK";
    }

    @RequestMapping(value="/addJilu")
    public @ResponseBody String addJilu(String patientId,String bingchengjilu){
        System.out.println("patientId"+patientId);
        Patient patient=new Patient();
        patient.setPatientId(patientId);
        patient.setBingchengjilu(bingchengjilu);
        patientService.addJilu(patient);
        return "addJiluOK";
    }

    @RequestMapping(value="/hushiUpdatePatient")
    public @ResponseBody String hushiUpdatePatient(String patientId, Integer patientAge,String dazhenshijian,String chafangshijian,
                                                   String bingchuangNo,String bingfangNo,String phone){
        Patient patient=new Patient();
        patient.setPatientId(patientId);
        patient.setPatientAge(patientAge);
        patient.setPhone(phone);
        patient.setDazhenshijian(dazhenshijian);
        patient.setChafangshijian(chafangshijian);
        patient.setBingchuangNo(bingchuangNo);
        patient.setBingfangNo(bingfangNo);
        patientService.hushiUpdatePatient(patient);
        return "updateOK";
    }

    @RequestMapping(value = "/selectPatient",method = RequestMethod.POST)
    public @ResponseBody Patient selectPatient(String patientName, HttpSession session){
        System.out.println("patientname: "+patientName);
        Patient patient=patientService.selectPatient(patientName);
        session.setAttribute("patient",patient);
        if(patient!=null){
            System.out.println(patient);
            return patient;
        }else{
            return null;
        }
    }

    @RequestMapping(value = "/doctorSelectPatient",method = RequestMethod.POST)
    public @ResponseBody Patient doctorSelectPatient(String patientName,String doctorId, HttpSession session){
        System.out.println("patientname: "+patientName);
        Patient patient=patientService.doctorSelectPatient(patientName,doctorId);
        session.setAttribute("patient",patient);
        if(patient!=null){
            System.out.println(patient);
            return patient;
        }else{
            return null;
        }
    }

    @RequestMapping(value = "/hushiSelectPatient",method = RequestMethod.POST)
    public @ResponseBody Patient hushiSelectPatient(String patientName,String hushiId, HttpSession session){
        System.out.println("patientname: "+patientName);
        Patient patient=patientService.hushiSelectPatient(patientName,hushiId);
        session.setAttribute("patient",patient);
        if(patient!=null){
            System.out.println(patient);
            return patient;
        }else{
            return null;
        }
    }


    @RequestMapping(value = "/doctorAndHushiViewAllPatient")
    public String doctorAndHushiViewPatient(){
        return "redirect:/doctorAndHushiViewAllPatient.html";
    }

    @RequestMapping(value = "/doctorViewOwnPatient")
    public String doctorViewOwnPatient(){
        return "redirect:/doctorViewOwnPatient.html";
    }

    @RequestMapping(value = "/doctorViewPatient")
    public @ResponseBody PageInfo<Patient> doctorViewPatient(String doctorName,String doctorId,Model model, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                      @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Patient> patientList=patientService.doctorViewPatient(doctorName,doctorId);
        System.out.println("date:  " + patientList);
        PageInfo<Patient> pageInfo=new PageInfo<Patient>(patientList,pageSize);
        model.addAttribute("patientList",patientList);
        model.addAttribute("pageInfo",pageInfo);
        return pageInfo;
    }


    @RequestMapping(value = "/hushiViewPatient")
    public @ResponseBody PageInfo<Patient> hushiViewPatient(String hushiName,String hushiId,Model model, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                             @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Patient> patientList=patientService.hushiViewPatient(hushiName,hushiId);
        System.out.println("date:  " + patientList);
        PageInfo<Patient> pageInfo=new PageInfo<Patient>(patientList,pageSize);
        model.addAttribute("patientList",patientList);
        model.addAttribute("pageInfo",pageInfo);
        return pageInfo;
    }

    @RequestMapping(value = "/hushiViewOwnPatient")
    public String hushiViewOwnPatient(){
        return "redirect:/hushiViewOwnPatient.html";
    }

}
