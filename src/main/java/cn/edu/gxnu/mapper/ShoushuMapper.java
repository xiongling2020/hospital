package cn.edu.gxnu.mapper;

import cn.edu.gxnu.bean.ShouShu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShoushuMapper {
    List<ShouShu> getShoushu();/*查看所有手术的信息*/
    void addShoushu(ShouShu shouShu);/*添加手术信息*/
    void deleteShoushu(String shoushuId);/*删除手术信息*/
    void updateShoushu(ShouShu shouShu);/*更新手术信息*/
    ShouShu selectShoushu(String shoushuId);/*根据id查看手术的具体信息*/
    ShouShu doctorSelectShoushu(@Param("shoushuId")String shoushuId,@Param("doctorId")String doctorId);/*医生根据手术id查看自己的手术信息*/
    ShouShu hushiSelectShoushu(@Param("shoushuId")String shoushuId,@Param("hushiId")String hushiId);/*护士根据手术id查看自己的手术信息*/

    List<ShouShu> doctorViewShoushu(@Param("doctorId") String doctorId, @Param("doctorName")String doctorName);/*医生查看属于自己的所有手术信息*/
    List<ShouShu> hushiViewShoushu(@Param("hushiId") String hushiId, @Param("hushiName")String hushiName);/*护士查看属于自己的所有手术信息*/
}
