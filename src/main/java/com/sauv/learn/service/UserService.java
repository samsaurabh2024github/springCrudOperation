package com.sauv.learn.service;

import com.sauv.learn.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto create(UserDto userDto);
    UserDto update(UserDto userDto,String userId);
    void delete(String Id);
    UserDto getUser(String userId);
    List<UserDto> getAllUsers();
}
