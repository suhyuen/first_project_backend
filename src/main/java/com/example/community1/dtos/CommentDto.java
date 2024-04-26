package com.example.community1.dtos;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private int userUid;
    private int postUid;
    private String content;

}
