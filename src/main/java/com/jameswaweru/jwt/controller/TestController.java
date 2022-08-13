package com.jameswaweru.jwt.controller;

import com.jameswaweru.jwt.config.StatusCodes;
import com.jameswaweru.jwt.dto.ResponseDTO;
import com.jameswaweru.jwt.entity.User;
import com.jameswaweru.jwt.repository.UserRepository;
import com.jameswaweru.jwt.services.UserService;
import com.jameswaweru.jwt.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@Slf4j
public class TestController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder encoder;


    @GetMapping("test")
    public String test() throws Exception{
        User myUser = userService.getUserByUserNameAndPassword("jim","1234");
        log.info("Fetched user details {} ",myUser);
        return "Hello";
    }

    @GetMapping("save-user")
    public ResponseDTO<?> saveUser(
            @RequestParam(required = true) String username,
            @RequestParam(required = true) String password
    ) throws Exception{

        if(userRepository.existsByUserName(username)){
            return new ResponseDTO<>(
                    StatusCodes.FAILED,
                    "Already exists"
            );
        }

        return new ResponseDTO<>(
                StatusCodes.SUCCESS,
                "Saved",
                Arrays.asList(userRepository.save(User.builder().userName(username).password(encoder.encode(password)).build()))
        );
    }


    @GetMapping("get-token")
    public ResponseDTO<?> getToken(
            @RequestParam(required = true) String username,
            @RequestParam(required = true) String password
    ) throws Exception{


        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

//        try{
//
//        }catch (Exception exception){
//
//        }


        var token = jwtUtil.generateToken(username);
        if(token != null){
            return new ResponseDTO<>(
                    StatusCodes.SUCCESS,
                    "Token generated",
                    Arrays.asList(token));
        }

        return new ResponseDTO<>(
                StatusCodes.FAILED,
                "Failed");
    }


}
