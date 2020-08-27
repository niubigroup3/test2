package com.citi.service;

import com.citi.bean.DemoBondsSalesRecord;
import com.citi.dao.BondMapper;
import org.aspectj.weaver.ast.Var;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BondService {

    @Resource
    private BondMapper bondMapper;

    public void insertBond(DemoBondsSalesRecord bond)
    {
         bondMapper.insertBond(bond);
    }

    public List<DemoBondsSalesRecord> selectBonds(String salesName, String bondsName) {
        List<DemoBondsSalesRecord> demoBondsSalesRecords = bondMapper.selectBondByName(salesName, bondsName);
        return demoBondsSalesRecords;
    }

    public DemoBondsSalesRecord selectBondById(int id) {
        DemoBondsSalesRecord demoBondsSalesRecord = bondMapper.selectBondById(id);
        return demoBondsSalesRecord;
    }

    public List<DemoBondsSalesRecord> selectBondByName(String salesName, String bondsName) {
        List<DemoBondsSalesRecord> demoBondsSalesRecords = bondMapper.selectBondByName(salesName, bondsName);
        return demoBondsSalesRecords;
    }

    public List<DemoBondsSalesRecord> selectAll() {
        List<DemoBondsSalesRecord> demoBondsSalesRecords = bondMapper.selectAll();
        return demoBondsSalesRecords;
    }
}
