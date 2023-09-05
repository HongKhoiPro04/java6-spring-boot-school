package com.example.demo.service;

import com.example.demo.dao.AccountDAO;
import com.example.demo.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    AccountDAO accountDAO;

    @Autowired
    BCryptPasswordEncoder pe;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        try{
            Account account = accountDAO.findById(username).get();
            String password = account.getPassword();
            String[] roles = account.getAuthorities().stream()
                    .map(au -> au.getRole().getId())
                    .collect(Collectors.toList()).toArray(new String[0]);
            return User.withUsername(username)
                    .password(pe.encode(password))
                    .roles(roles).build();
        }catch (Exception e){
            throw new UsernameNotFoundException(username + "not found");
        }
    }
}
