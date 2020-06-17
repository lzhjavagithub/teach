package com.itcast.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ErrorController {

    @RequestMapping("/error/403")
    @ResponseBody
    public String error() {
        return "/error/403";
    }

}
