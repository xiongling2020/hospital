package cn.edu.gxnu.service;

import cn.edu.gxnu.bean.ShouShu;
import java.util.List;

public interface IShoushuService {
    List<ShouShu> getShoushu();
    void addShoushu(ShouShu shouShu);
    void deleteShoushu(String shoushuId);
    void updateShoushu(ShouShu shouShu);
    ShouShu selectShoushu(String shoushuId);
    ShouShu doctorSelectShoushu(String shoushuId, String doctorId);
    ShouShu hushiSelectShoushu(String shoushuId,String hushiId);

    List<ShouShu> doctorViewShoushu(String doctorId, String doctorName);
    List<ShouShu> hushiViewShoushu(String hushiId, String hushiName);
}
