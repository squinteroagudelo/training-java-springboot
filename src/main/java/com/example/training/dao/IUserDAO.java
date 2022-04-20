package com.example.training.dao;

import com.example.training.domain.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDAO extends JpaRepository<UserDomain, Long> {
    UserDomain findByUsername(String username);
}
