package cn.edu.gxnu.bean;

public class Bingfang {
    private String bingfangId;
    private String bingfangNo;
    private String keshiId;
    private String keshiName;
    private int kongchuangshu;
    private Keshi keshi;
    private int zongchuangshu;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Keshi getKeshi() {
        return keshi;
    }

    public void setKeshi(Keshi keshi) {
        this.keshi = keshi;
    }

    public String getBingfangId() {
        return bingfangId;
    }

    public void setBingfangId(String bingfangId) {
        this.bingfangId = bingfangId;
    }

    public String getBingfangNo() {
        return bingfangNo;
    }

    public int getKongchuangshu() {
        return kongchuangshu;
    }

    public void setKongchuangshu(int kongchuangshu) {
        this.kongchuangshu = kongchuangshu;
    }

    public int getZongchuangshu() {
        return zongchuangshu;
    }

    public void setZongchuangshu(int zongchuangshu) {
        this.zongchuangshu = zongchuangshu;
    }

    public void setBingfangNo(String bingfangNo) {
        this.bingfangNo = bingfangNo;
    }

    public String getKeshiId() {
        return keshiId;
    }

    public void setKeshiId(String keshiId) {
        this.keshiId = keshiId;
    }

    public String getKeshiName() {
        return keshiName;
    }

    public void setKeshiName(String keshiName) {
        this.keshiName = keshiName;
    }


}
