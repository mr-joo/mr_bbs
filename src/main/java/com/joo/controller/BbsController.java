package com.joo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BbsController {
    @RequestMapping("bbs")
    public String printHello() {
        return "main";
    }

    @RequestMapping("write")
    public String getWritePage() {
        return "write";
    }

    @RequestMapping("detail")
    public String getDetailPage() {
        return "detail";
    }
}
