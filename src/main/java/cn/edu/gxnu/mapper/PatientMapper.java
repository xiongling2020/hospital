package cn.edu.gxnu.mapper;

import cn.edu.gxnu.bean.Patient;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatientMapper {
    List<Patient> getPatient();/*查看所有病人信息*/
    void addPatient(Patient patient);/*添加病人信息*/
    Patient lookUpPatient(String patientId);/*根据病人id查看病人的具体信息*/
    void deletePatient(String patientId);/*删除病人信息*/
    void updatePatient(Patient patient);/*更新病人信息*/
    void addJilu(Patient patient);/*医生为病人添加病程记录*/
    void hushiUpdatePatient(Patient patient);/*护士更新病人信息*/
    Patient selectPatient(String patientName);/*根据病人姓名查看病人具体信息*/
    Patient doctorSelectPatient(@Param("patientName") String patientName,@Param("doctorId") String doctorId);/*医生根据姓名查看病人具体信息*/
    Patient hushiSelectPatient(@Param("patientName") String patientName,@Param("hushiId") String hushiId);/*护士根据姓名查看病人具体信息*/

    List<Patient> doctorViewPatient(@Param("doctorName") String doctorName, @Param("doctorId") String doctorId);/*医生查看属于自己的所有病人的信息*/
    List<Patient> hushiViewPatient(@Param("hushiName") String hushiName, @Param("hushiId") String hushiId);/*医生查看属于自己的所有病人的信息*/

}
