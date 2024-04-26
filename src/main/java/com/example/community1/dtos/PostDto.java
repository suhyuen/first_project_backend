package com.example.community1.dtos;

import com.example.community1.models.Category;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostDto {
    private int uid;
    private String title;
    private String content;
    private int viewer;
    private String nickname;
    private LocalDateTime createdAt;
    private int likeCount;
    private int categoryUid;
}