package cn.edu.gxnu.service.impl;

import cn.edu.gxnu.bean.Keshi;
import cn.edu.gxnu.mapper.KeshiMapper;
import cn.edu.gxnu.service.IKeshiService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class KeshiServiceImpl implements IKeshiService {
    @Autowired
    KeshiMapper keshiMapper;

    @Override
    public List<Keshi> getKeshi() {
        return keshiMapper.getKeshi();
    }

    @Override
    public void addKeshi(Keshi keshi) {
        keshiMapper.addKeshi(keshi);
    }

    @Override
    public Keshi lookUpKeshi(String keshiId) {
        return keshiMapper.lookUpKeshi(keshiId);
    }

    @Override
    public void deleteKeshi(String keshiId) {
        keshiMapper.deleteKeshi(keshiId);
    }

    @Override
    public void updateKeshi(Keshi keshi) {
        keshiMapper.updateKeshi(keshi);
    }

    @Override
    public Keshi selectKeshi(String keshiName) {
        return keshiMapper.selectKeshi(keshiName);
    }
}
