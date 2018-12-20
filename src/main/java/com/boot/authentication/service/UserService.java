package com.boot.authentication.service;


import com.boot.authentication.converter.UserConverter;
import com.boot.authentication.dto.UserDto;
import com.boot.authentication.entity.User;
import com.boot.authentication.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    // Define the log object for this class
    private final Logger log = Logger.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Transactional
    public List<UserDto> findAllUsers() {
        return userRepository.findAll().stream().map(userConverter::entityToDto).collect(Collectors.toList());
    }

    //Get user by user id
    @Transactional
    public UserDto getUser(Long id) {
        User user =  userRepository.findById(id).orElse(new User());

        if (user.getId()==null){
            log.info("User not found");
        }else{
            log.info("User found " + user.getUserName());
        }
        return userConverter.entityToDto(user);
    }

    //Save or update user
    @Transactional
    public String userSaveOrUpdate(UserDto userDto) {

        System.out.println(userDto.toString());

        User user = userConverter.dtoToEntity(userDto);

        //Check the user exist or not
//        UserDto userResult =  getUser(user.getId());

        userRepository.save(user);

//        if (userResult.getId()==0){
//            log.info("User has been successfully inserted");
//            return "User has been successfully inserted";
//        }else if (userResult.getId()!=0){
//            log.info("User has been successfully updated");
//            return "User has been successfully updated";
//        }else{
//            log.info("User has not been inserted");
//            return "User has not been inserted";
//        }
        return "User has been successfully inserted";
    }

    @Transactional
    public String deleteUser(Long id) {

        //Check the user exist or not
        UserDto userResult =  getUser(id);

        if (userResult.getId()!=0){
            userRepository.deleteById(id);
            log.info("User has been successfully deleted");
            return "User has been successfully deleted";
        }else{
            log.info("User not found");
            return "User not found";
        }

    }

}
