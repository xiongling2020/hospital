package cn.edu.gxnu.service.impl;

import cn.edu.gxnu.bean.Bingfang;
import cn.edu.gxnu.mapper.BingfangMapper;
import cn.edu.gxnu.service.IBingfangService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class BingfangServiceImpl implements IBingfangService {
    @Autowired
    BingfangMapper bingfangMapper;

    @Override
    public List<Bingfang> getBingfang() {
        return bingfangMapper.getBingfang();
    }

    @Override
    public void addBingfang(Bingfang bingfang) {
        bingfangMapper.addBingfang(bingfang);
    }

    @Override
    public void deleteBingfang(String bingfangId) {
        bingfangMapper.deleteBingfang(bingfangId);
    }

    @Override
    public void updateBingfang(Bingfang bingfang) {
        bingfangMapper.updateBingfang(bingfang);
    }

    @Override
    public Bingfang selectBingfang(String bingfangId) {
        return bingfangMapper.selectBingfang(bingfangId);
    }
}
