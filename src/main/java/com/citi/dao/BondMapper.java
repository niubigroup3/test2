package com.citi.dao;

import com.citi.bean.DemoBondsSalesRecord;
import com.citi.bean.DemoUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BondMapper {

    public void insertBond(DemoBondsSalesRecord bond);

    public List<DemoBondsSalesRecord> selectBondByName(String salesName, String bondsName);

    public DemoBondsSalesRecord selectBondById(int id);

    public List<DemoBondsSalesRecord> selectAll();
}
