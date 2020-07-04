package cn.edu.gxnu.service.impl;

import cn.edu.gxnu.bean.Patient;
import cn.edu.gxnu.mapper.PatientMapper;
import cn.edu.gxnu.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PatientServiceImpl implements IPatientService {
    @Autowired
    PatientMapper patientMapper;

    @Override
    public List<Patient> getPatient() {
        return patientMapper.getPatient();
    }

    @Override
    public void addPatient(Patient patient) {
        patientMapper.addPatient(patient);
    }

    @Override
    public Patient lookUpPatient(String patientId) {
        return patientMapper.lookUpPatient(patientId);
    }

    @Override
    public void deletePatient(String patientId) {
        patientMapper.deletePatient(patientId);
    }

    @Override
    public void updatePatient(Patient patient) {
        patientMapper.updatePatient(patient);
    }

    @Override
    public void addJilu(Patient patient) {
        patientMapper.addJilu(patient);
    }

    @Override
    public void hushiUpdatePatient(Patient patient) {
        patientMapper.hushiUpdatePatient(patient);
    }

    @Override
    public Patient selectPatient(String patientName) {
        return patientMapper.selectPatient(patientName);
    }

    @Override
    public Patient doctorSelectPatient(String patientName, String doctorId) {
        return patientMapper.doctorSelectPatient(patientName,doctorId);
    }

    @Override
    public Patient hushiSelectPatient(String patientName, String hushiId) {
        return patientMapper.hushiSelectPatient(patientName,hushiId);
    }

    @Override
    public List<Patient> doctorViewPatient(String doctorName, String doctorId) {
        return patientMapper.doctorViewPatient(doctorName,doctorId);
    }

    @Override
    public List<Patient> hushiViewPatient(String hushiName, String hushiId) {
        return patientMapper.hushiViewPatient(hushiName,hushiId);
    }
}
