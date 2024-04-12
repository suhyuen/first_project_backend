package com.example.community1.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Post {
    private int uid;
    public String categoriesUid;
    public String title;
    public String content;
    public int likes;
    public int viewer;
    private int userUid;
}
