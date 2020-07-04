package cn.edu.gxnu.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Timestamp;
import java.util.Date;

public class ShouShu {
    private String shoushuId;
    private String patientId;
    private String doctorId;

    @JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss",timezone="GMT+8")/*添加该注解后能在页面显示数据库中的日期以及解决页面显示时间与数据库时间相差的问题*/
    private Timestamp startTime;

    @JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss",timezone="GMT+8")
    private Timestamp overTime;

    private String doctorName;
    private String patientName;
    private String bingfangId;
    private String shoushushi;
    private String hushiId;
    private String hushiName;
    private String guimo;
    private String xingzhi;

    public String getGuimo() {
        return guimo;
    }

    public void setGuimo(String guimo) {
        this.guimo = guimo;
    }

    public String getXingzhi() {
        return xingzhi;
    }

    public void setXingzhi(String xingzhi) {
        this.xingzhi = xingzhi;
    }

    public String getHushiId() {
        return hushiId;
    }

    public void setHushiId(String hushiId) {
        this.hushiId = hushiId;
    }

    public String getHushiName() {
        return hushiName;
    }

    public void setHushiName(String hushiName) {
        this.hushiName = hushiName;
    }

    public String getShoushushi() {
        return shoushushi;
    }

    public void setShoushushi(String shoushushi) {
        this.shoushushi = shoushushi;
    }

    public String getShoushuId() {
        return shoushuId;
    }

    public void setShoushuId(String shoushuId) {
        this.shoushuId = shoushuId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Date getOverTime() {
        return overTime;
    }

    public void setOverTime(Timestamp overTime) {
        this.overTime = overTime;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getBingfangId() {
        return bingfangId;
    }

    public void setBingfangId(String bingfangId) {
        this.bingfangId = bingfangId;
    }
}
