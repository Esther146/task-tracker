package com.esther.activitytracker.service;

import com.esther.activitytracker.model.User;
import com.esther.activitytracker.payload.LoginDto;
import com.esther.activitytracker.payload.UserDto;
import com.esther.activitytracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createNewUser(UserDto userDto){
        User appUser = new User();

        appUser.setFirstname(userDto.getFirstname());
        appUser.setLastname(userDto.getLastname());
        appUser.setEmail(userDto.getEmail());
        appUser.setPassword(userDto.getPassword());

        return userRepository.save(appUser);
    }

//    public User findById(Long id) {
//        Optional<User> facebookUser = userRepository.findById(id);
//        if(facebookUser.isEmpty()){
//            return null;
//        }
//        return facebookUser.get();
//    }

    public String loginAUser(LoginDto loginDto){
        Optional<User> query = userRepository.findByEmail(loginDto.getEmail());
        if (query.isPresent()){
            User user = query.get();
            if (user.getPassword().equals(loginDto.getPassword())){
                return "successful";
            }
            return "incorrect password" ;
        }
        return "user does not exist";
    }

}
