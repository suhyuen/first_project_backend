package com.example.community1.services;

import com.example.community1.dtos.UserDto;
import com.example.community1.mappers.UserMapper;
import com.example.community1.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    PasswordEncoder passwordEncoder;

    public UserService() {
    }

    public void signup(UserDto userDto) {
        User user = User.builder().userId(userDto.getUserId()).userPw(this.passwordEncoder.encode(userDto.getUserPw())).userName(userDto.getUserName()).nickname(userDto.getNickname()).phonenumber(userDto.getPhonenumber()).email(userDto.getEmail()).build();
        this.userMapper.insertUser(user);
    }

    public UserDto mypage(int userUid) {
        return this.userMapper.information(userUid);
    }

    public void login(String userId){
        Optional<User> userOptional = userMapper.userLogin(userId);
        if (userOptional.isPresent()){
            System.out.println("Login successful");
        } else {
            throw new NoSuchElementException("User not fount");
        }
    }

    public UserDto findPassword(UserDto userDto) {
        return this.userMapper.findPassword(userDto);
    }

    public void updateUser(UserDto userDto, int uid) {
        User user = User.builder().uid(uid).userId(userDto.getUserId()).nickname(userDto.getNickname()).email(userDto.getEmail()).phonenumber(userDto.getPhonenumber()).build();
        this.userMapper.updateUser(user);
    }
}

