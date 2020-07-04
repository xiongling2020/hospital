package cn.edu.gxnu.service;
import cn.edu.gxnu.bean.Manager;
import cn.edu.gxnu.bean.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IManagerService {
    Manager login(String managerLoginName, String managerPassword);
    List<Permission> getManagerPermission(String rolesId,String managerId);
    void updateOwn(Manager manager);
    void changePwd(Manager manager);
    Manager selectOwn( String managerId);
}
