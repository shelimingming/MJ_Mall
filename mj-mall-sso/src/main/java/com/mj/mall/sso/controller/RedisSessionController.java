package com.mj.mall.sso.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class RedisSessionController {
    @GetMapping("index")
    public String index(HttpServletRequest request) {
        request.getSession().setAttribute("key","value");
        return "success";
    }

    @Value("${server.port}")
    private String port;

    @RequestMapping("/setsession")
    public String setSeesion(HttpServletRequest request, String key, String value) {
        HttpSession session = request.getSession();
        session.setAttribute(key, value);
        return "server port :" + port + "---- value :" + value;
    }

    @RequestMapping("/getsession")
    public String getSeesion(HttpServletRequest request, String key) {
        HttpSession session = request.getSession();
        String value = (String) session.getAttribute(key);
        return "server port :" + port + "---- value :" + value;
    }
}
