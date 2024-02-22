package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.models.User;
import com.scaler.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User signUp(String email, String password){
        // Check if user already exists
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent()){
            throw new RuntimeException("User with this email already exists.");
        }
        //Create a new User object and persist in DB
        User user = new User();
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setBookings(new ArrayList<>());


        User savedUser = userRepository.save(user);
        return savedUser;
    }
}


//Logic to match pwd in login Feature

//1. Store hashed pwd
//2 At the time of login, ask for pwd attempt from user
//3 salt it and get salted pwd for user(based on email) and match
