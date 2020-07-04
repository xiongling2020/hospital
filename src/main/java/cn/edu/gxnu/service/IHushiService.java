package cn.edu.gxnu.service;

import cn.edu.gxnu.bean.Hushi;
import cn.edu.gxnu.bean.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IHushiService {
    Hushi login(String hushiLoginName, String hushiPassword);
    List<Permission> getHushiPermission( String rolesId, String hushiId);
    List<Hushi> getHushi();
    void addHushi(Hushi hushi);
    void deleteHushi(String hushiId);
    void updateHushi(Hushi hushi);
    Hushi lookUpHushi(String hushiId);
    Hushi selectHushi(String hushiName);
    void updateOwn(Hushi hushi);
    void changePassword(Hushi hushi);
    Hushi selectOwn(String hushiId);
}
