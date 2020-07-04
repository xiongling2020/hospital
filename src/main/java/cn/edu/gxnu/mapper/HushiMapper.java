package cn.edu.gxnu.mapper;

import cn.edu.gxnu.bean.Hushi;
import cn.edu.gxnu.bean.Permission;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface HushiMapper {
    Hushi login(@Param("hushiLoginName") String hushiLoginName, @Param("hushiPassword") String hushiPassword);
    List<Permission> getHushiPermission(@Param("rolesId")String rolesId,@Param("hushiId") String hushiId);
    List<Hushi> getHushi();/*管理员查看所有护士信息*/
    void addHushi(Hushi hushi);/*管理员添加护士信息*/
    void deleteHushi(String hushiId);/*管理员根据id删除护士信息*/
    void updateHushi(Hushi hushi);/*管理员更新护士信息*/
    Hushi lookUpHushi(String hushiId);/*管理员根据ID查看护士具体信息*/
    Hushi selectHushi(String hushiName);/*管理员根据护士姓名查看护士具体信息*/
    void updateOwn(Hushi hushi);/*护士更新个人信息*/
    void changePassword(Hushi hushi);/*护士修改密码*/
    Hushi selectOwn(@Param("hushiId") String hushiId);/*护士查看个人信息*/
}
