package cn.edu.gxnu.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.Date;

public class Patient {
    private String patientId;
    private String patientName;
    private String patientSex;
    private int patientAge;
    private String phone;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")/*添加该注解后能在页面显示数据库中的日期以及解决页面显示时间与数据库时间相差的问题*/
    private Date zhuYuanRiQi;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date chuYuanRiQi;
    private String zhengZhuang;
    private String doctorName;
    private String doctorId;
    private String hushiName;
    private String hushiId;
    private String bingfangNo;
    private String address;
    private String bingchuangNo;
    private String guomin;
    private String yizhu;
    private String chafangshijian;
    private String dazhenshijian;
    private String medicine;
    private String bingchengjilu;


    @JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss",timezone="GMT+8")
    private Timestamp shoushushijian;

    public String getChafangshijian() {
        return chafangshijian;
    }

    public void setChafangshijian(String chafangshijian) {
        this.chafangshijian = chafangshijian;
    }

    public String getDazhenshijian() {
        return dazhenshijian;
    }

    public void setDazhenshijian(String dazhenshijian) {
        this.dazhenshijian = dazhenshijian;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public Timestamp getShoushushijian() {
        return shoushushijian;
    }

    public void setShoushushijian(Timestamp shoushushijian) {
        this.shoushushijian = shoushushijian;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBingchuangNo() {
        return bingchuangNo;
    }

    public void setBingchuangNo(String bingchuangNo) {
        this.bingchuangNo = bingchuangNo;
    }

    public String getGuomin() {
        return guomin;
    }

    public void setGuomin(String guomin) {
        this.guomin = guomin;
    }

    public String getYizhu() {
        return yizhu;
    }

    public void setYizhu(String yizhu) {
        this.yizhu = yizhu;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getHushiName() {
        return hushiName;
    }

    public void setHushiName(String hushiName) {
        this.hushiName = hushiName;
    }

    public String getHushiId() {
        return hushiId;
    }

    public void setHushiId(String hushiId) {
        this.hushiId = hushiId;
    }

    public String getBingfangNo() {
        return bingfangNo;
    }

    public void setBingfangNo(String bingfangNo) {
        this.bingfangNo = bingfangNo;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getZhuYuanRiQi() {
        return zhuYuanRiQi;
    }

    public void setZhuYuanRiQi(Date zhuYuanRiQi) {
        this.zhuYuanRiQi = zhuYuanRiQi;
    }

    public Date getChuYuanRiQi() {
        return chuYuanRiQi;
    }

    public void setChuYuanRiQi(Date chuYuanRiQi) {
        this.chuYuanRiQi = chuYuanRiQi;
    }

    public String getZhengZhuang() {
        return zhengZhuang;
    }

    public void setZhengZhuang(String zhengZhuang) {
        this.zhengZhuang = zhengZhuang;
    }

    public String getBingchengjilu() {
        return bingchengjilu;
    }

    public void setBingchengjilu(String bingchengjilu) {
        this.bingchengjilu = bingchengjilu;
    }
}
