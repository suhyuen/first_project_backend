package com.example.community1.models;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private int uid;
    private int userUid;
    private int postUid;
    private String content;
    private LocalDateTime createdAt;
    private int likeCount;
    private Post post;
    private User user;
}
