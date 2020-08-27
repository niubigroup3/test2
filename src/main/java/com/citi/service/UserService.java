package com.citi.service;

import com.citi.bean.DemoUser;
import com.citi.dao.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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

    @Autowired
    private HttpSession session;


    public DemoUser findUserById(int id) {
        return userMapper.selectUserById(id);
    }

    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<>();

        // 空值处理
        if (StringUtils.isBlank(username)) {
            map.put("usernameMsg", "账号不能为空!");
            return map;
        }
        if (StringUtils.isBlank(password)) {
            map.put("passwordMsg", "密码不能为空!");
            return map;
        }

        // 验证账号
        DemoUser user = userMapper.selectUserByName(username);

        if (user == null) {
            map.put("usernameMsg", "该账号不存在!");
            return map;
        }


        // 验证密码
        if (!user.getPass().equals(password)) {
            map.put("passwordMsg", "密码不正确!");
            return map;
        } else {

            user.setStatus(1);

            userMapper.updateUserStatus( user.getStatus(), user.getId());

            session.setAttribute("username", user);

            map.put("success", "登录成功");

        }

        return map;

    }


    public void logout(DemoUser user) {
        user.setStatus(0);
        userMapper.updateUserStatus(user.getStatus(), user.getId());
        session.removeAttribute("username");
    }

}
