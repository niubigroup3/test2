package com.citi.dao;

import com.citi.Group3Application;
import com.citi.bean.DemoUser;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Auther: chenle
 * @Date: 2020/8/24 - 18:54
 * @Description: com.citi.mapper
 * @version: 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Group3Application.class)
class UserMapperTest {

    @Resource
    UserMapper userMapper;

    @Test
    void insertUser() {

        DemoUser user = new DemoUser();
        user.setName("admin");
        user.setPass("admin");
        user.setUpdatedAt(new Date());
        user.setCreatedAt(new Date());
        user.setStatus(0);
        int i = userMapper.insertUser(user);
        System.out.println(i);
        System.out.println(user);
    }


    @Test
    void testDeleteUser() {
    }

    @Test
    void selectUserById() {

        DemoUser demoUser = userMapper.selectUserById(1);
        System.out.println(demoUser);

    }

    @Test
    void updateUserStatus() {

        int i = userMapper.updateUserStatus(1, 8);
        System.out.println(i);

    }

    @Test
    void selectUserByName() {
        DemoUser user = userMapper.selectUserByName("admin");
        System.out.println(user);
    }
}