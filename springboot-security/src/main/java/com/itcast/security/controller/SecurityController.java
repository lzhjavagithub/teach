package com.itcast.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // 页面和项目同架构时 不可以返回json
@RequestMapping("/sec")
public class SecurityController {

    /**
     * 首页
     */
    @RequestMapping("/index")
    public String securityDemo() {
        return "index";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add() {
        return "新增页面";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update() {
        return "修改页面";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete() {
        return "删除页面";
    }

    @RequestMapping("/find")
    @ResponseBody
    public String find() {
        return "查询页面";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

}
