package cn.edu.gxnu.service.impl;

import cn.edu.gxnu.bean.ShouShu;
import cn.edu.gxnu.mapper.ShoushuMapper;
import cn.edu.gxnu.service.IShoushuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShoushuServiceImpl implements IShoushuService {
    @Autowired
    ShoushuMapper shoushuMapper;

    @Override
    public List<ShouShu> getShoushu() {
        return shoushuMapper.getShoushu();
    }

    @Override
    public void addShoushu(ShouShu shouShu) {
        shoushuMapper.addShoushu(shouShu);
    }

    @Override
    public void deleteShoushu(String shoushuId) {
        shoushuMapper.deleteShoushu(shoushuId);
    }

    @Override
    public void updateShoushu(ShouShu shouShu) {
        shoushuMapper.updateShoushu(shouShu);
    }

    @Override
    public ShouShu selectShoushu(String shoushuId) {
        return shoushuMapper.selectShoushu(shoushuId);
    }

    @Override
    public ShouShu doctorSelectShoushu(String shoushuId, String doctorId) {
        return shoushuMapper.doctorSelectShoushu(shoushuId,doctorId);
    }

    @Override
    public ShouShu hushiSelectShoushu(String shoushuId, String hushiId) {
        return shoushuMapper.hushiSelectShoushu(shoushuId,hushiId);
    }

    @Override
    public List<ShouShu> doctorViewShoushu(String doctorId, String doctorName) {
        return shoushuMapper.doctorViewShoushu(doctorId,doctorName);
    }

    @Override
    public List<ShouShu> hushiViewShoushu(String hushiId, String hushiName) {
        return shoushuMapper.hushiViewShoushu(hushiId,hushiName);
    }
}
