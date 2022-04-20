package com.example.training.service;

import com.example.training.dao.IUserDAO;
import com.example.training.domain.Role;
import com.example.training.domain.UserDomain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service("userDetailsService")
@Slf4j
public class UserService implements UserDetailsService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDomain user = userDAO.findByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException(username);

        var roles = new ArrayList<GrantedAuthority>();

        for (Role role : user.getRoles())
            roles.add(new SimpleGrantedAuthority(role.getName()));

        return new User(user.getUsername(), user.getPassword(), roles);
    }
}
