package cn.edu.gxnu.bean;

public class Medicine {
    private String medicineId;
    private String medicineName;
    private int buyingPrice;
    private int sellingPrice;
    private String medicineNo;
    private String shengchanshang;
    private int kucun;

    public int getKucun() {
        return kucun;
    }

    public void setKucun(int kucun) {
        this.kucun = kucun;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(int buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getMedicineNo() {
        return medicineNo;
    }

    public void setMedicineNo(String medicineNo) {
        this.medicineNo = medicineNo;
    }

    public String getShengchanshang() {
        return shengchanshang;
    }

    public void setShengchanshang(String shengchanshang) {
        this.shengchanshang = shengchanshang;
    }
}
