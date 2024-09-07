package com.sauv.learn.service.impl;

import com.sauv.learn.dto.UserDto;
import com.sauv.learn.entity.User;
import com.sauv.learn.reposatory.USerReposatory;
import com.sauv.learn.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private USerReposatory userReposatory;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto create(UserDto userDto) {
        String userId = UUID.randomUUID().toString();
        userDto.setId(userId);
        User map = modelMapper.map(userDto, User.class);
        User save = userReposatory.save(map);
        UserDto map1 = modelMapper.map(save, UserDto.class);
        return map1;
    }

    @Override
    public UserDto update(UserDto userDto, String userId) {
        User userNotFound = userReposatory.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        userNotFound.setName(userDto.getName());
        userNotFound.setPassword(userDto.getPassword());
        User save = userReposatory.save(userNotFound);
        return modelMapper.map(save, UserDto.class);


    }

    @Override
    public void delete(String userId) {
        User userNotFound = userReposatory.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        userReposatory.delete(userNotFound);
    }

    @Override
    public UserDto getUser(String userId) {
        User userNotFound = userReposatory.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return modelMapper.map(userNotFound, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<User> users = userReposatory.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

}
