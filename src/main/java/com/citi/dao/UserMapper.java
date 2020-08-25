package com.citi.dao;

import com.citi.bean.DemoUser;
import org.apache.ibatis.annotations.Mapper;


/**
 * @Auther: chenle
 * @Date: 2020/8/24 - 15:12
 * @Description: com.citi.dao
 * @version: 1.0
 */


@Mapper
public interface UserMapper {


    public int insertUser(DemoUser user);

    public int updateUserStatus(Integer status, Integer id);

    public DemoUser selectUserById(Integer id);

    public DemoUser selectUserByName(String name);

    public int deleteUser(DemoUser user);


}
