package com.joo.controller;


import com.joo.model.Comment;
import com.joo.model.Post;
import com.joo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        if (post.getTitle().length() == 0) {
            throw new RuntimeException();
        } else if (post.getTitle().length() > 20) {
            throw new RuntimeException();
        } else if (post.getMainText().length() == 0) {
            throw new RuntimeException();
        } else if (post.getMainText().length() > 200) {
            throw new RuntimeException();
        } else if (post.getName().length() == 0) {
            throw  new RuntimeException();
        } else if (post.getName().length() > 20) {
            throw new RuntimeException();
        }

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

    @RequestMapping(value = "insertComment", method = RequestMethod.POST)
    public String insertReply(Comment comment) {
        postService.insertComment(comment);
        return "redirect:/detail/" + comment.getPostNum();
    }

    @RequestMapping(value = "/updateComment", method = RequestMethod.POST)
    @ResponseBody
    public String updateComment(Comment comment) {
        String updatedCommentText = postService.updateComment(comment);
        return updatedCommentText;
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

    @RequestMapping(value = "deleteComment", method = RequestMethod.GET)
    public String deleteComment(Comment comment) {
        postService.deleteComment(comment);
        return "redirect:/detail/" + comment.getPostNum();
    }
}
