package cn.edu.gxnu.service;

import cn.edu.gxnu.bean.Patient;
import java.util.List;

public interface IPatientService {
    List<Patient> getPatient();
    void addPatient(Patient patient);
    Patient lookUpPatient(String patientId);
    void deletePatient(String patientId);
    void updatePatient(Patient patient);
    void addJilu(Patient patient);
    void hushiUpdatePatient(Patient patient);
    Patient selectPatient(String patientName);
    Patient doctorSelectPatient(String patientName,String doctorId);
    Patient hushiSelectPatient(String patientName,String hushiId);

    List<Patient> doctorViewPatient(String doctorName,String doctorId);
    List<Patient> hushiViewPatient(String hushiName,String hushiId);
}
