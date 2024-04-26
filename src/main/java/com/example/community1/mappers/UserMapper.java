package com.example.community1.mappers;

import com.example.community1.dtos.UserDto;
import com.example.community1.models.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {
    void insertUser(User user);

    UserDto information(int i);

    Optional<User> userLogin(String userId);

    UserDto findPassword(UserDto userDto);

    void updateUser(User user);

    void deleteUser(User user);
}