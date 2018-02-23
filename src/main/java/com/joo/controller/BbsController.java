package com.joo.controller;


import com.joo.model.Post;
import com.joo.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BbsController {
    @Autowired
    private PostServiceImpl postServiceImpl;

    @RequestMapping("bbs")
    public String mainPage() {
        return "main";
    }

    @RequestMapping(value = "write", method = RequestMethod.GET)
    public String getWritePage() {
        return "write";
    }

    @RequestMapping(value = "write", method = RequestMethod.POST)
    public String write(Post post) {
        postServiceImpl.write(post);
        return "redirect:/bbs";
    }

    @RequestMapping("detail")
    public String getDetailPage() {
        return "detail";
    }
}
