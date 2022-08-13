package com.jameswaweru.jwt.services;

import com.jameswaweru.jwt.entity.User;
import com.jameswaweru.jwt.repository.UserRepository;
import com.sun.xml.bind.v2.TODO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@Slf4j
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    public User getUserByUserNameAndPassword(String userName , String password){
        return userRepository.getUserByUserNameAndPassword(userName, password);
    }

    public User getUserByUserName(String username){
        return userRepository.getUserByUserName(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("About to loadUserByUsername by {} ", username);
        //TODO
        User userDetails = getUserByUserName(username);
        log.info("Fetched user details {} ", userDetails);
        if(userDetails == null){
            throw new UsernameNotFoundException("User not found ");
        }
        return new org.springframework.security.core.userdetails.User(userDetails.getUserName(), userDetails.getPassword(), new ArrayList<>());
    }
}
