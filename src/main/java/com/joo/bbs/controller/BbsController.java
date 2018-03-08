package com.joo.bbs.controller;


import com.joo.bbs.model.Comment;
import com.joo.bbs.model.Post;
import com.joo.bbs.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BbsController {
    private static final Logger logger = LoggerFactory.getLogger(BbsController.class);

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
        postService.writePost(post);

        return "redirect:/bbs";
    }

    @RequestMapping(value = "/detail/{postNum}", method = RequestMethod.GET)
    public String showDetailPage(@PathVariable int postNum, Model model) {
        Post post = postService.showPost(postNum);
        model.addAttribute("post", post);
        List<Comment> commentList = postService.getCommentList(postNum);
        model.addAttribute("commentList", commentList);

        return "detail";
    }

    @RequestMapping(value = "/update/{postNum}", method = RequestMethod.GET)
    public String getModifyPage(@PathVariable int postNum, Model model) {
        Post post = postService.showPost(postNum);
        model.addAttribute("post", post);

        return "update";
    }

    @RequestMapping(value = "/updatePost", method = RequestMethod.POST)
    public String modifyPost(Post post) {
        postService.modifyPost(post);

        return "redirect:/detail/" + post.getPostNum();
    }

    @RequestMapping(value = "insertComment", method = RequestMethod.POST)
    public String insertReply(Comment comment) {
        postService.createComment(comment);

        return "redirect:/detail/" + comment.getPostNum();
    }

    @RequestMapping(value = "/updateComment", method = RequestMethod.POST)
    @ResponseBody
    public String updateComment(Comment comment) {
        postService.updateComment(comment);

        return "success";
    }

    @RequestMapping(value = "/delete/{postNum}", method = RequestMethod.GET)
    public String removePost(@PathVariable int postNum) {
        postService.removePost(postNum);

        return "redirect:/bbs";
    }

    @RequestMapping(value = "/deleteComment", method = RequestMethod.GET)
    @ResponseBody
    public void deleteComment(Comment comment) {
        postService.removeComment(comment);
    }
}
