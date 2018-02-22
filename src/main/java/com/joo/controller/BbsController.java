package com.joo.controller;


import com.joo.model.Post;
import com.joo.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BbsController {
    @Autowired
    private PostServiceImpl postServiceImpl;

    @RequestMapping(value = "write", method = RequestMethod.GET)
    public String getWritePage(Model model) {
        model.addAttribute("post", new Post());
        return "write";
    }

    @RequestMapping(value = "write", method = RequestMethod.POST)
    public String write(@RequestParam("title") String title, @RequestParam("main_text") String main_text, Post post) {
        postServiceImpl.write(post);
        return "redirect:/main";
    }

    @RequestMapping("bbs")
    public String mainPage() {
        return "main";
    }

    @RequestMapping("detail")
    public String getDetailPage() {
        return "detail";
    }
}
