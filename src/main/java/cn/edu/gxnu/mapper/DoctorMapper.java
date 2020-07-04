package cn.edu.gxnu.mapper;

import cn.edu.gxnu.bean.Doctor;
import cn.edu.gxnu.bean.Permission;
import org.apache.ibatis.annotations.Param;
import org.w3c.dom.views.DocumentView;

import java.util.List;

public interface DoctorMapper {
    Doctor login(@Param("doctorLoginName") String doctorLoginName,
                 @Param("doctorPassword") String doctorPassword);

    List<Permission> getDoctorPermission(@Param("rolesId") String rolesId,
                                         @Param("doctorId")String doctorId);

    List<Doctor> getDoctor();/*管理员获取所有医生信息*/
    void addDoctor(Doctor doctor);/*管理员添加医生信息*/
    void deleteDoctor(String doctorId);/*管理员删除医生信息*/
    void updateDoctor(Doctor doctor);/*管理员更新医生信息*/
    Doctor lookUpDoctor(String doctorId);/*管理员根据id查看医生具体信息*/
    Doctor selectDoctor(String doctorName);/*管理员根据姓名查看医生信息*/
    void updateOwn(Doctor doctor);/*医生更新个人信息*/
    void changePassword(Doctor doctor);/*医生修改密码*/
    Doctor selectOwn(@Param("doctorId") String doctorId);/*医生查看个人信息*/
}


