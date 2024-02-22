package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.dtos.SignUpRequestDTO;
import com.scaler.bookmyshow.dtos.SignUpResponseDTO;
import com.scaler.bookmyshow.enums.ResponseStatus;
import com.scaler.bookmyshow.models.User;
import com.scaler.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public SignUpResponseDTO signUp(SignUpRequestDTO signUpRequestDTO){
        SignUpResponseDTO responseDTO = new SignUpResponseDTO();
        try{
            User user = userService.signUp(signUpRequestDTO.getEmail(),signUpRequestDTO.getPassword());
            responseDTO.setUserId(user.getId());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }

}
