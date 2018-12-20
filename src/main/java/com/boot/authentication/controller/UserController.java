package com.boot.authentication.controller;

import com.boot.authentication.converter.UserConverter;
import com.boot.authentication.dto.UserDto;
import com.boot.authentication.entity.User;
import com.boot.authentication.repository.UserRepository;
import com.boot.authentication.repository.UserRepositoryCustom;
import com.boot.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepositoryCustom userRepositoryCustom;

    @Autowired
    private UserConverter userConverter;

    @PostMapping(value = "/users")
    public DataTablesOutput<User> list(@RequestBody DataTablesInput input) {
        return userRepositoryCustom.findAll(input);
    }

//    Get User by user id
    @GetMapping(value = "/users/{id}")
    public UserDto getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    //Save User
    @PostMapping(value = "/users/add")
    public String addUser(@RequestBody UserDto userDto){

        System.out.println(">>>"+userDto.toString());
        String status = userService.userSaveOrUpdate(userDto);
        return status;
    }

    //Update User
    @PutMapping(value = "/users")
    public String updateUser(@RequestBody UserDto userDto){

        System.out.println(">>>"+userDto.toString());
        String status = userService.userSaveOrUpdate(userDto);
        return status;
    }

    //Delete User
    @DeleteMapping(value = "/users/{id}")
    public String deleteUser(@PathVariable Long id){
        String status = userService.deleteUser(id);
        return status;
    }
}
