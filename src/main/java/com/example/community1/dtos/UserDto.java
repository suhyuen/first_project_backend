package com.example.community1.dtos;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Builder
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int uid;
    private String userId;
    private String userPw;
    private String nickname;
    private String userName;
    private String email;
    private String phonenumber;
}

