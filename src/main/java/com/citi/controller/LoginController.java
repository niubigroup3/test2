package com.citi.controller;

import com.citi.bean.DemoUser;
import com.citi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Auther: chenle
 * @Date: 2020/8/24 - 13:48
 * @Description: com.citi.controller
 * @version: 1.0
 */

@Controller
public class LoginController {

    @Autowired
    UserService userService;
    
    private static String login = "/login";
    
    private static String usernameMsg = "usernameMsg";
    
    private static String pwMsg = "passwordMsg";

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String admin() {
        return "redirect:/login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login() {
        return login;
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String getRegisterPage() {
        return "/register";
    }


    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(Model model, DemoUser user) {
        Map<String, Object> map = userService.register(user);
        if (map == null || map.isEmpty()) {
            model.addAttribute("msg", "注册成功");
            return login;
        } else {
            model.addAttribute(usernameMsg, map.get(usernameMsg));
            model.addAttribute(pwMsg, map.get(pwMsg));
            return "/register";
        }
    }


    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(String username, String password, Model model, HttpSession session, HttpServletResponse response) {

        // 检查账号,密码
        Map<String, Object> map = userService.login(username, password);
        if (map.containsKey("success")) {
            return "redirect:/manage";
        } else {
            model.addAttribute(usernameMsg, map.get(usernameMsg));
            model.addAttribute(pwMsg, map.get(pwMsg));
            return login;
        }
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout(DemoUser user) {
        userService.logout(user);
        return "redirect:/login";
    }

}
