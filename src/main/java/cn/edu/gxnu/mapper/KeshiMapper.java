package cn.edu.gxnu.mapper;

import cn.edu.gxnu.bean.Keshi;

import java.util.List;

public interface KeshiMapper {
    List<Keshi> getKeshi();
    void addKeshi(Keshi keshi);
    Keshi lookUpKeshi(String keshiId);
    void deleteKeshi(String keshiId);
    void updateKeshi(Keshi keshi);
    Keshi selectKeshi(String keshiName);
}
