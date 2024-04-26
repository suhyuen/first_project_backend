package com.example.community1.mappers;

import com.example.community1.dtos.CommentDto;
import com.example.community1.models.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    void insertComment(Comment comment);
    List<Comment> selectComment(int postUid);
}
