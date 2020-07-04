package cn.edu.gxnu.mapper;

import cn.edu.gxnu.bean.Manager;
import cn.edu.gxnu.bean.Permission;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface ManagerMapper {
    Manager login(@Param("managerLoginName") String managerLoginName, @Param("managerPassword") String managerPassword);

    List<Permission> getManagerPermission(@Param("rolesId") String rolesId,@Param("managerId")String managerId);

    void updateOwn(Manager manager);/*更新管理员个人信息*/

    void changePwd(Manager manager);/*修改管理员密码*/

    Manager selectOwn(@Param("managerId") String managerId);/*查看管理员个人信息*/
}
