package com.example.community1.models;

import com.example.community1.dtos.CategoriesDto;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Post {
    private int uid;
    private String title;
    private String content;
    private int likeCount;
    private int viewer;
    private int userUid;
    private int categoryUid;
    private String categoryName;
    private LocalDateTime createdAt;
    private User user;
}
