package com.example.community1.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Like {
    private int uid;
    private int userUid;
    private int postUid;
}
