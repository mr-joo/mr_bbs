package com.joo.controller;


import com.joo.model.Post;
import com.joo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BbsController {
    @Autowired
    private PostService postService;

    @RequestMapping(value = "bbs", method = RequestMethod.GET)
    public String getMainPage(Model model) {
        List<Post> postList = postService.getPostList();
        model.addAttribute("postList", postList);
        return "main";
    }

    @RequestMapping(value = "write", method = RequestMethod.GET)
    public String getWritePage() {
        return "write";
    }

    @RequestMapping(value = "write", method = RequestMethod.POST)
    public String write(Post post) {
        postService.write(post);
        return "redirect:/bbs";
    }

    @RequestMapping("/detail/{postNum}")
    public String showDetailPage(@PathVariable int postNum, Model model) {
        Post post = postService.showPost(postNum);
        model.addAttribute("post", post);
        return "detail";
    }

    @RequestMapping(value = "/update/{postNum}", method = RequestMethod.GET)
    public String getUpdatePage(@PathVariable int postNum, Model model) {
        Post post = postService.showPost(postNum);
        model.addAttribute("post", post);
        return "update";
    }

    @RequestMapping(value = "/update/{postNum}", method = RequestMethod.POST)
    public String updatePost(@PathVariable int postNum, Model model, Post post) {
        Post updatedPost = postService.updatePost(postNum, post);
        model.addAttribute("post", updatedPost);
        return "detail";
    }

    @RequestMapping(value = "/delete/{postNum}", method = RequestMethod.GET)
    public String deletePost(@PathVariable int postNum) {
        postService.deletePost(postNum);
        return "redirect:/bbs";
    }
}
