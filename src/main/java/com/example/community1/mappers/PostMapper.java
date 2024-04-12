package com.example.community1.mappers;

import com.example.community1.dtos.PostDto;
import com.example.community1.models.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    void insertPost(Post var1);

    List<PostDto> selectPosts(int var1);

    List<PostDto> myPosts(int var1);

    PostDto detailMypost(int var1);

    void updatePost(Post var1);
}

