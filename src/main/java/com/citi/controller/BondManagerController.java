package com.citi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: chenle
 * @Date: 2020/8/24 - 22:47
 * @Description: com.citi.controller
 * @version: 1.0
 */
@Controller
public class BondManagerController {

    @RequestMapping(path = "/manage", method = RequestMethod.GET)
    public String login() {
        return "BondManagement";
    }


}
