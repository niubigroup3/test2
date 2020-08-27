package com.citi.dao;

import com.citi.bean.DemoBondsSalesRecord;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: chenle
 * @Date: 2020/8/26 - 15:32
 * @Description: com.citi.dao
 * @version: 1.0
 */
class BondMapperTest {

    @Resource
    BondMapper bondMapper;

    @Test
    void selectBondByName() {

        List<DemoBondsSalesRecord> demoBondsSalesRecords = bondMapper.selectBondByName("lwj", "zfzq");
        for (DemoBondsSalesRecord demoBondsSalesRecord : demoBondsSalesRecords) {

                System.out.println(demoBondsSalesRecord);

        }

    }


    @Test
    void selectBondById() {
        DemoBondsSalesRecord demoBondsSalesRecord = bondMapper.selectBondById(1);
        System.out.println(demoBondsSalesRecord);
    }


}