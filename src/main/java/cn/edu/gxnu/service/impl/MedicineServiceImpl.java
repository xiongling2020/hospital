package cn.edu.gxnu.service.impl;

import cn.edu.gxnu.bean.Medicine;
import cn.edu.gxnu.mapper.MedicineMapper;
import cn.edu.gxnu.service.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MedicineServiceImpl implements IMedicineService {
    @Autowired
    MedicineMapper medicineMapper;

    @Override
    public List<Medicine> getMedicine() {
        return medicineMapper.getMedicine();
    }

    @Override
    public void addMedicine(Medicine medicine) {
         medicineMapper.addMedicine(medicine);
    }

    @Override
    public Medicine lookUpMedicine(String medicineId) {
        return medicineMapper.lookUpMedicine(medicineId);
    }

    @Override
    public void deleteMedicine(String medicineId) {
        medicineMapper.deleteMedicine(medicineId);
    }

    @Override
    public void updateMedicine(Medicine medicine) {
        medicineMapper.updateMedicine(medicine);
    }

    @Override
    public Medicine selectMedicine(String medicineName) {
        return medicineMapper.selectMedicine(medicineName);
    }
}
