package com.example.springsecuritytest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RouterController {

    @RequestMapping({"/","/index"})
    public String index() {
        return "views/index";
    }


    @RequestMapping("/toLogin")
    public String toLogin() {
        return "views/login";
    }

    @RequestMapping("/level1/{id}")
    public String level1(@PathVariable("id") int  id) {
        System.out.println("level1"+id);
        return "views/level1";
    }

    @RequestMapping("/level2/{id}")
    public String level2(@PathVariable("id") int  id) {
        System.out.println("level2"+id);
        return "views/level2";
    }

    @RequestMapping("/level3/{id}")
    public String level3(@PathVariable("id") int  id) {
        System.out.println("level1"+id);
        return "views/level3";
    }

    @PostMapping("/loginget")
    public String loginget(String username,String passwd) {
        System.out.println("login");
        System.out.println(username+passwd);
        return "views/index";
    }
}
