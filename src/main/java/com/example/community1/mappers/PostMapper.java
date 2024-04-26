package com.example.community1.mappers;

import com.example.community1.dtos.PostDto;
import com.example.community1.models.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    void insertPost(Post post);

    List<PostDto> selectAllPosts();

    List<PostDto> selectPosts(int categoriesUid);

    List<PostDto> myPosts(int userUid);

    Post detailMypost(int uid);

    void updatePost(Post post);

    void deletePost(Post post);

}

