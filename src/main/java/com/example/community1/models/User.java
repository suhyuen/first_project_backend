package com.example.community1.models;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User {
    private int uid;
    private String userId;
    private String userPw;
    private String nickname;
    private String userName;
    private String phonenumber;
    private String email;
    private LocalDateTime createdAt;
    private String auth;
}
