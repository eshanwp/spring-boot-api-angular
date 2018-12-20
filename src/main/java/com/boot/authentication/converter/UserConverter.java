package com.boot.authentication.converter;

import com.boot.authentication.dto.UserDto;
import com.boot.authentication.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public static User dtoToEntity(UserDto userDto){

        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setUserName(userDto.getUserName());

        return user;
    }

    public UserDto entityToDto(User user){

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setUserName(user.getUserName());
        return userDto;
    }
}
