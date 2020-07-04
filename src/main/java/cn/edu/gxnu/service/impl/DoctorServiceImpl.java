package cn.edu.gxnu.service.impl;

import cn.edu.gxnu.bean.Doctor;
import cn.edu.gxnu.bean.Permission;
import cn.edu.gxnu.mapper.DoctorMapper;
import cn.edu.gxnu.service.IDoctorService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DoctorServiceImpl implements IDoctorService {
    @Autowired
    DoctorMapper doctorMapper;

    @Override
    public Doctor login(String doctorLoginName, String doctorPassword) {
        return doctorMapper.login(doctorLoginName,doctorPassword);
    }

    @Override
    public List<Permission> getDoctorPermission(String rolesId, String doctorId) {
        return doctorMapper.getDoctorPermission(rolesId,doctorId);
    }

    @Override
    public List<Doctor> getDoctor() {
        return doctorMapper.getDoctor();
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctorMapper.addDoctor(doctor);
    }

    @Override
    public void deleteDoctor(String doctorId) {
        doctorMapper.deleteDoctor(doctorId);
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        doctorMapper.updateDoctor(doctor);
    }

    @Override
    public Doctor lookUpDoctor(String doctorId) {
        return doctorMapper.lookUpDoctor(doctorId);
    }

    @Override
    public Doctor selectDoctor(String doctorName) {
        return doctorMapper.selectDoctor(doctorName);
    }

    @Override
    public void updateOwn(Doctor doctor) {
       doctorMapper.updateOwn(doctor);
    }

    @Override
    public void changePassword(Doctor doctor) {
        doctorMapper.changePassword(doctor);
    }

    @Override
    public Doctor selectOwn(String doctorId) {
        return doctorMapper.selectOwn(doctorId);
    }
}
