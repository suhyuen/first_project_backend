package com.example.community1.controller;

import com.example.community1.dtos.UserDto;
import com.example.community1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    public UserController() {
    }

    @PostMapping({"/signup"})
    public String signup(@RequestBody UserDto userDto) {
        userService.signup(userDto);
        return "test";
    }

    @PostMapping({"/mypage"})
    public UserDto mypage() {
        System.out.println("Hello");
        int userUid = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.mypage(userUid);
    }

    @PostMapping({"/login"})
    public String login(@RequestBody UserDto userDto) {
        userService.login(userDto.getUserId());
        return "test";
    }

    @PostMapping({"/findpassword"})
    public UserDto findPassword(@RequestBody UserDto userDto) {
        return this.userService.findPassword(userDto);
    }

    @PostMapping({"/change"})
    public void updateUser(@RequestBody UserDto userDto) {
        int userUid = (Integer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userService.updateUser(userDto, userUid);
    }
}
