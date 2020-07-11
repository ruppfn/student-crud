package com.educacionit.student.api.service.impl;

import com.educacionit.student.api.entity.UserEntity;
import com.educacionit.student.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        UserEntity userEntity = userRepository.findByUsername(username);
        if(userEntity == null){
            throw new UsernameNotFoundException(username);
        }

        return new User(userEntity.getUsername(), userEntity.getPassword(), Collections.emptyList());
    }
}