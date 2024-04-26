package com.example.community1.controller;

import com.example.community1.dtos.PostDto;
import com.example.community1.models.Post;
import com.example.community1.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostService postService;

    public PostController() {
    }

    @PostMapping({"/write"})
    public String write(@RequestBody PostDto postDto) {
        int userUid = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.postService.write(postDto, userUid);
        return "test";
    }

    @PostMapping({"/write2"})
    public String write2(@RequestBody PostDto postDto) {
        int userUid = (Integer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.postService.write(postDto, userUid);
        return "test";
    }

    @PostMapping({"/write3"})
    public String write3(@RequestBody PostDto postDto) {
        int userUid = (Integer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.postService.write(postDto, userUid);
        return "test";
    }

    @PostMapping({"/write4"})
    public String write4(@RequestBody PostDto postDto) {
        int userUid = (Integer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.postService.write(postDto, userUid);
        return "test";
    }

    @PostMapping({"/write5"})
    public String write5(@RequestBody PostDto postDto) {
        int userUid = (Integer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.postService.write(postDto, userUid);
        return "test";
    }

    @PostMapping({"/write6"})
    public String write56(@RequestBody PostDto postDto) {
        int userUid = (Integer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.postService.write(postDto, userUid);
        return "test";
    }

    @GetMapping("/")
    public List<PostDto> homepage(){
        return this.postService.selectAllPosts();
    }

    @GetMapping({"/hello"})
    public List<PostDto> hello(@RequestParam("categoriesUid") int categoriesUid) {
        return this.postService.posts(categoriesUid);
    }

    @GetMapping({"/community"})
    public List<PostDto> communityPage(@RequestParam("categoriesUid") int categoriesUid) {
        return this.postService.posts(categoriesUid);
    }

    @GetMapping({"/funcommunity"})
    public List<PostDto> funcommunity(@RequestParam("categoriesUid") int categoriesUid) {
        return this.postService.posts(categoriesUid);
    }

    @GetMapping({"/ootd"})
    public List<PostDto> ootd(@RequestParam("categoriesUid") int categoriesUid) {
        return this.postService.posts(categoriesUid);
    }

    @GetMapping({"/usedsales"})
    public List<PostDto> usedsales(@RequestParam("categoriesUid") int categoriesUid) {
        return this.postService.posts(categoriesUid);
    }

    @GetMapping({"/usedpurchase"})
    public List<PostDto> usedpurchase(@RequestParam("categoriesUid") int categoriesUid) {
        return this.postService.posts(categoriesUid);
    }

    @PostMapping({"/myposts"})
    public List<PostDto> myposts() {
        int userUid = (Integer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return this.postService.myposts(userUid);
    }

    @GetMapping({"/detailpost"})
    public Post detailpost(@RequestParam("uid") int postUid) {
        return this.postService.detailMypost(postUid);
    }

    @GetMapping({"/detailmypost"})
    public Post detailmypost(@RequestParam("uid") int postUid) {
        return this.postService.detailMypost(postUid);
    }

    @PostMapping({"/editpost"})
    public PostDto updatePost(@RequestBody PostDto postDto) {
        int userUid = (Integer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.postService.updatePost(postDto, userUid);
        return postDto;
    }

    @PostMapping("/detailpost/{postUid}/deletepost")
    public String deletePost(@RequestBody PostDto postDto) {
        int userUid = (Integer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postService.deletePost(postDto, userUid);
        return "test";
    }
}
