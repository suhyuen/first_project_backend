package com.example.community1.services;

import com.example.community1.dtos.PostDto;
import com.example.community1.mappers.PostMapper;
import com.example.community1.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostMapper postMapper;

    public PostService() {
    }

    public void write(PostDto postDto, int userUid) {
        Post post = Post.builder()
                .categoryUid(postDto.getCategoryUid())
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .likeCount(postDto.getLikeCount())
                .viewer(postDto.getViewer())
                .userUid(userUid)
                .build();
        this.postMapper.insertPost(post);
    }

    public List<PostDto> selectAllPosts(){
        return this.postMapper.selectAllPosts();
    }

    public List<PostDto> posts(int categoriesUid) {
        return this.postMapper.selectPosts(categoriesUid);
    }

    public List<PostDto> myposts(int userUid) {
        return this.postMapper.myPosts(userUid);
    }

    public Post detailMypost(int postUid) {
        return this.postMapper.detailMypost(postUid);
    }

    public void updatePost(PostDto postDto, int userUid) {
        Post post = Post.builder().title(postDto.getTitle()).content(postDto.getContent()).userUid(userUid).uid(postDto.getUid()).build();
        this.postMapper.updatePost(post);
    }

    public void deletePost(PostDto postDto, int userUid){
        Post post = Post.builder()
                .uid(postDto.getUid())
                .userUid(userUid)
                .build();
        postMapper.deletePost(post);
    }
}

