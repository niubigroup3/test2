package com.citi.controller;

import com.citi.bean.DemoUser;
import com.citi.service.UserService;
import com.citi.util.CommunityConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Auther: chenle
 * @Date: 2020/8/24 - 13:48
 * @Description: com.citi.controller
 * @version: 1.0
 */

@Controller
public class LoginController implements CommunityConstant {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String admin() {
        return "redirect:/login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login() {
        return "/login";
    }


    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(String username, String password, Model model, HttpServletResponse response) {

        // 检查账号,密码
        Map<String, Object> map = userService.login(username, password);

        if (map.containsKey("success")) {
            return "BondManagement";
        } else {
            model.addAttribute("usernameMsg", map.get("usernameMsg"));
            model.addAttribute("passwordMsg", map.get("passwordMsg"));
            return "login";
        }

    }


    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout(DemoUser user) {
        userService.logout(user);
        return "redirect:/login";
    }

}
