package cn.edu.gxnu.service.impl;

import cn.edu.gxnu.bean.Manager;
import cn.edu.gxnu.bean.Permission;
import cn.edu.gxnu.mapper.ManagerMapper;
import cn.edu.gxnu.service.IManagerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ManagerServiceImpl implements IManagerService {
    @Autowired
    ManagerMapper managerMapper;

    @Override
    public Manager login(String managerLoginName, String managerPassword) {
        return managerMapper.login(managerLoginName,managerPassword);
    }

    @Override
    public List<Permission> getManagerPermission(String rolesId, String managerId) {
        return managerMapper.getManagerPermission(rolesId,managerId);
    }

    @Override
    public void updateOwn(Manager manager) {
        managerMapper.updateOwn(manager);
    }


    @Override
    public void changePwd(Manager manager) {
        managerMapper.changePwd(manager);
    }

    @Override
    public Manager selectOwn(String managerId) {
        return managerMapper.selectOwn(managerId);
    }

}
