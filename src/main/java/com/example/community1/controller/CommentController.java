package com.example.community1.controller;

import com.example.community1.dtos.CommentDto;
import com.example.community1.models.Comment;
import com.example.community1.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;
    public CommentController(){

    }

    @PostMapping("/detailpost/{postUid}/comments")
    public String wirteComment(@RequestBody CommentDto commentDto, @PathVariable("postUid") int postUid){
        int userUid = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        commentService.writecomment(commentDto,userUid,postUid);
        return "test";
    }

    @GetMapping("/detailpost/comments")
    public List<Comment> selectComments(@RequestParam(value="postUid") int postUid){
        return commentService.selectComment(postUid);
    }
}

