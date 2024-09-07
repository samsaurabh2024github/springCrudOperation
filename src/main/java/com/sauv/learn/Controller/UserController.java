package com.sauv.learn.Controller;

import com.sauv.learn.dto.UserDto;
import com.sauv.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public UserDto createUser(@RequestBody UserDto userDto) {
        UserDto userDto1 = userService.create(userDto);
        return userDto1;
    }
    @PutMapping("/update/{userId}")
    public UserDto updateUser(@RequestBody UserDto userDto,@PathVariable("userId") String userId) {
        UserDto update = userService.update(userDto, userId);
        return update;
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId") String userId) {
        userService.delete(userId);
        return "User Deleted Successfully";
    }

    @GetMapping("/get/{userId}")
    public UserDto getUser(@PathVariable("userId") String userId) {
        UserDto user = userService.getUser(userId);
        return user;
    }

    @GetMapping("/getAll")
    public List<UserDto> getAllUsers() {
        List<UserDto> allUsers = userService.getAllUsers();
        return allUsers;
    }
}
