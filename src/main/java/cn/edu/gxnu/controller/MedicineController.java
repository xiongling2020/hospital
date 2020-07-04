package cn.edu.gxnu.controller;

import cn.edu.gxnu.bean.Medicine;
import cn.edu.gxnu.service.IMedicineService;
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

@RequestMapping("/medicine")
@Controller
public class MedicineController {
    @Autowired
    IMedicineService medicineService;
    @RequestMapping(value = "/getMedicine")
    public @ResponseBody
    PageInfo<Medicine> getMedicine(Model model, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Medicine> medicineList=medicineService.getMedicine();
        System.out.println("date:  " + medicineList);
        PageInfo<Medicine> pageInfo=new PageInfo<Medicine>(medicineList,pageSize);
        model.addAttribute("medicineList",medicineList);
        model.addAttribute("pageInfo",pageInfo);
        return pageInfo;
    }

    /*先查询到数据存放在session作用域中，之后再取出来并显示*/
    @RequestMapping(value = "/viewMedicine")
    public String viewMedicine(){
        return "redirect:/viewMedicine.html";
    }

    @RequestMapping(value = "/addMedicine",method = RequestMethod.POST)
    public @ResponseBody String addMedicine(String medicineName,Integer buyingPrice, Integer sellingPrice, String medicineNo,String shengchanshang,Integer kucun){
        Medicine medicine=new Medicine();
        medicine.setMedicineName(medicineName);
        medicine.setBuyingPrice(buyingPrice);
        medicine.setSellingPrice(sellingPrice);
        medicine.setMedicineNo(medicineNo);
        medicine.setShengchanshang(shengchanshang);
        medicine.setKucun(kucun);
        medicine.setMedicineId(UUID.randomUUID().toString().replace("-",""));
        medicineService.addMedicine(medicine);
        return "addOK";
    }

    @RequestMapping(value="/deleteMedicine")
    public @ResponseBody String deleteMedicine(String medicineId){
        medicineService.deleteMedicine(medicineId);
        return "deleteOK";
    }

    @RequestMapping(value = "/lookUpMedicine",method = RequestMethod.POST)
    public @ResponseBody Medicine lookUpMedicine(String medicineId, HttpSession session){
        System.out.println("medicineId" + medicineId);
        Medicine medicine=medicineService.lookUpMedicine(medicineId);
        System.out.println("medicine" + medicine);
        return medicine;
    }

    @RequestMapping(value="/updateMedicine")
    public @ResponseBody String updateMedicine(String medicineId, Integer buyingPrice,Integer sellingPrice,Integer kucun){
        Medicine medicine=new Medicine();
        medicine.setMedicineId(medicineId);
        medicine.setBuyingPrice(buyingPrice);
        medicine.setSellingPrice(sellingPrice);
        medicine.setKucun(kucun);
        medicineService.updateMedicine(medicine);
        return "updateOK";
    }

    @RequestMapping(value = "/selectMedicine",method = RequestMethod.POST)
    public @ResponseBody Medicine selectMedicine(String medicineName, HttpSession session){
        System.out.println("medicineName: "+medicineName);
        Medicine medicine=medicineService.selectMedicine(medicineName);
        session.setAttribute("medicine",medicine);
        if(medicine!=null){
            System.out.println(medicine);
            return medicine;
        }else{
            return null;
        }
    }

}
