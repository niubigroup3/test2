package com.citi.intercepter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Auther: chenle
 * @Date: 2020/8/25 - 13:39
 * @Description: com.citi.intercepter
 * @version: 1.0
 */

@Component
public class LoginRequiredInterceptor implements HandlerInterceptor {

    @Autowired
    HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            if (session.getAttribute("username") == null) {
                response.sendRedirect("/login");
                return false;
            }
        }
        return true;
    }

}
