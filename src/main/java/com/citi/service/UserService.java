package com.citi.service;

import com.citi.bean.DemoUser;
import com.citi.dao.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: chenle
 * @Date: 2020/8/24 - 23:49
 * @Description: com.citi.service
 * @version: 1.0
 */

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;
    
    private static String usernameMsg = "usernameMsg";
    
    private static String pwMsg = "passwordMsg";


    public DemoUser findUserById(int id) {
        return userMapper.selectUserById(id);
    }

    public Map<String, Object> register(DemoUser user) {

        Map<String, Object> map = new HashMap<>();

        // 空值处理
        if (user == null) {
            throw new IllegalArgumentException("参数不能为空!");
        }
        if (StringUtils.isBlank(user.getName())) {
            map.put(usernameMsg, "账号不能为空!");
            return map;
        }
        if (StringUtils.isBlank(user.getPass())) {
            map.put(pwMsg, "密码不能为空!");
            return map;
        }

        // 验证账号
        DemoUser u = userMapper.selectUserByName(user.getName());
        if (u != null) {
            map.put(usernameMsg, "该账号已存在!");
            return map;
        }

        // 注册用户
        user.setName(user.getName());
        user.setPass(user.getPass());
        user.setStatus(0);
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        userMapper.insertUser(user);

        return map;
    }


    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<>();

        // 空值处理
        if (StringUtils.isBlank(username)) {
            map.put(usernameMsg, "账号不能为空!");
            return map;
        }
        if (StringUtils.isBlank(password)) {
            map.put(pwMsg, "密码不能为空!");
            return map;
        }

        // 验证账号
        DemoUser user = userMapper.selectUserByName(username);

        if (user == null) {
            map.put(usernameMsg, "该账号不存在!");
            return map;
        }


        // 验证密码
        if (!user.getPass().equals(password)) {
            map.put(pwMsg, "密码不正确!");
            return map;
        }

        user.setStatus(1);

        userMapper.updateUserStatus(user.getStatus(), user.getId());

        map.put("success", "登录成功");

        return map;
    }


    public void logout(DemoUser user) {
        user.setStatus(0);
        userMapper.updateUserStatus(user.getStatus(), user.getId());
    }

}
