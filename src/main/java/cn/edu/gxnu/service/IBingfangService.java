package cn.edu.gxnu.service;

import cn.edu.gxnu.bean.Bingfang;

import java.util.List;

public interface IBingfangService {
    List<Bingfang> getBingfang();
    void addBingfang(Bingfang bingfang);
    void deleteBingfang(String bingfangId);
    void updateBingfang(Bingfang bingfang);
    Bingfang selectBingfang(String bingfangId);
}
