package com.joo.bbs.controller;


import com.joo.bbs.model.Comment;
import com.joo.bbs.model.Post;
import com.joo.bbs.service.PostService;
import org.apache.commons.lang3.BooleanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class BbsController {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(BbsController.class);

    @Autowired
    private PostService postService;

    @RequestMapping(value = "bbs", method = RequestMethod.GET)
    public String getMainPage(Model model) {
        List<Post> postList = postService.getPostList();
        model.addAttribute("postList", postList);

        return "main";
    }

    @RequestMapping(value = "createPost", method = RequestMethod.GET)
    public String getWritePage() {
        return "write";
    }

    @RequestMapping(value = "createPost", method = RequestMethod.POST)
    @ResponseBody
    public String createPost(Post post) {
        return BooleanUtils.toStringTrueFalse(postService.createPost(post));
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile (@RequestParam("uploadFile") MultipartFile uploadFile, int postNum) throws IOException {
        if (!uploadFile.isEmpty()) {
            String fileName = uploadFile.getOriginalFilename();
            uploadFile.transferTo(new File("C:/Users/NTS/Pictures/uploadFile/" + postNum + "/" + fileName));
        }

        return "fileNum";
    }

    @RequestMapping(value = "/detail/{postNum}", method = RequestMethod.GET)
    public String getDetailPage(@PathVariable int postNum, Model model) {
        model.addAttribute("post", postService.getPost(postNum));
        model.addAttribute("commentList", postService.getCommentList(postNum));

        return "detail";
    }

    @RequestMapping(value = "/update/{postNum}", method = RequestMethod.GET)
    public String getModifyPage(@PathVariable int postNum, Model model) {
        Post post = postService.getPost(postNum);
        model.addAttribute("post", post);

        return "update";
    }

    @RequestMapping(value = "/updatePost", method = RequestMethod.POST)
    public String modifyPost(Post post, @RequestParam("uploadFile") MultipartFile uploadFile) throws IOException {
        if (!uploadFile.isEmpty()) {
            logger.info("fileName : " + uploadFile.getName());
            String fileName = uploadFile.getOriginalFilename();
            uploadFile.transferTo(new File("C:\\Users\\NTS\\Pictures\\uploadFile\\" + fileName));
        }

        postService.modifyPost(post);

        return "redirect:/detail/" + post.getPostNum();
    }

    @RequestMapping(value = "insertComment", method = RequestMethod.POST)
    public String createComment(Comment comment) {
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
