package cn.edu.gxnu.service.impl;

import cn.edu.gxnu.bean.Hushi;
import cn.edu.gxnu.bean.Permission;
import cn.edu.gxnu.mapper.HushiMapper;
import cn.edu.gxnu.service.IHushiService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HushiServiceImpl implements IHushiService {
   @Autowired
    HushiMapper hushiMapper;

    @Override
    public Hushi login(String hushiLoginName, String hushiPassword) {
        return hushiMapper.login(hushiLoginName,hushiPassword);
    }

    @Override
    public List<Permission> getHushiPermission(String rolesId,String hushiId) {
        return hushiMapper.getHushiPermission(rolesId,hushiId);
    }

    @Override
    public List<Hushi> getHushi() {
        return hushiMapper.getHushi();
    }

    @Override
    public void addHushi(Hushi hushi) {
        hushiMapper.addHushi(hushi);
    }

    @Override
    public void deleteHushi(String hushiId) {
        hushiMapper.deleteHushi(hushiId);
    }

    @Override
    public void updateHushi(Hushi hushi) {
        hushiMapper.updateHushi(hushi);
    }

    @Override
    public Hushi lookUpHushi(String hushiId) {
        return hushiMapper.lookUpHushi(hushiId);
    }

    @Override
    public Hushi selectHushi(String hushiName) {
        System.out.println("hushiname" + hushiName);
        return hushiMapper.selectHushi(hushiName);
    }

    @Override
    public void updateOwn(Hushi hushi) {
        hushiMapper.updateOwn(hushi);
    }

    @Override
    public void changePassword(Hushi hushi) {
        hushiMapper.changePassword(hushi);
    }

    @Override
    public Hushi selectOwn(String hushiId) {
        return hushiMapper.selectOwn(hushiId);
    }
}
