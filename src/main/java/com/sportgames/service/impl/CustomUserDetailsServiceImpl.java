package com.sportgames.service.impl;

import com.sportgames.dao.UserDAO;
import com.sportgames.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    private final UserDAO userDAO;

    @Autowired
    public CustomUserDetailsServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDAO.findByLogin(s);
        if (user == null) {
            throw new UsernameNotFoundException("USER not found");
        }
        return user;
    }
}
