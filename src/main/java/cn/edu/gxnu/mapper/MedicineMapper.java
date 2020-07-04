package cn.edu.gxnu.mapper;

import cn.edu.gxnu.bean.Medicine;

import java.util.List;

public interface MedicineMapper {
    List<Medicine> getMedicine();
    void addMedicine(Medicine medicine);
    Medicine lookUpMedicine(String medicineId);
    void deleteMedicine(String medicineId);
    void updateMedicine(Medicine medicine);
    Medicine selectMedicine(String medicineName);
}
