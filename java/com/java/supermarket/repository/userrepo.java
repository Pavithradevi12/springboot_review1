package com.java.supermarket.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.supermarket.Model.user;

@Repository
public interface userrepo extends JpaRepository<user, Integer> {

    void save(User updatedUser);    
}