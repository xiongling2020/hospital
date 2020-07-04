package cn.edu.gxnu.service;
import cn.edu.gxnu.bean.Doctor;
import cn.edu.gxnu.bean.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IDoctorService {
    Doctor login(String doctorLoginName,String doctorPassword);
    List<Permission> getDoctorPermission(String rolesId,String doctorId);
    List<Doctor> getDoctor();
    void addDoctor(Doctor doctor);
    void deleteDoctor(String doctorId);
    void updateDoctor(Doctor doctor);
    Doctor lookUpDoctor(String doctorId);
    Doctor selectDoctor(String doctorName);
    void updateOwn(Doctor doctor);
    void changePassword(Doctor doctor);
    Doctor selectOwn(String doctorId);
}
