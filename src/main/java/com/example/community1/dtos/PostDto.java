package com.example.community1.dtos;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PostDto {
    private int uid;
    private String title;
    private String content;
    private String categoriesUid;
    private int likes;
    private int viewer;
    private String nickname;
    private LocalDateTime createdAt;
}