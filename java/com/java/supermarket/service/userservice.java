package com.java.supermarket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.supermarket.Model.user;
import com.java.supermarket.repository.userrepo;

@Service
public class userservice {
    @Autowired
    private userrepo repo;

    @SuppressWarnings("null")
    public user createuser(user a){
        return repo.save(a);
    }

    public List<user> getAllusers(){
        return repo.findAll();
    }

    @SuppressWarnings("null")
    public Optional<user> getuserById(Integer userId){
        return repo.findById(userId);
    }

    @SuppressWarnings("null")
    public boolean deleteUser(Integer userId) {
        if (repo.existsById(userId)) {
            repo.deleteById(userId);
            return true;
        }
        return false;
    }

    @SuppressWarnings("null")
    public user updateUser(user updatedUser) {
        // Assuming the user object provided already exists in the database
        return repo.save(updatedUser);
    }
}
