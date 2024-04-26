package com.example.community1.services;

import com.example.community1.dtos.CommentDto;
import com.example.community1.mappers.CommentMapper;
import com.example.community1.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;

    public CommentService(){

    }

    public void writecomment(CommentDto commentDto, int userUid, int postUid){
        Comment comment = Comment.builder()
                .userUid(userUid)
                .postUid(postUid)
                .content(commentDto.getContent())
                .build();
        commentMapper.insertComment(comment);
    }

    public List<Comment> selectComment(int postUid){
        return commentMapper.selectComment(postUid);
    }
}
