package com.java.supermarket.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.java.supermarket.Model.user;
import com.java.supermarket.service.userservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class apicontroller {
    @Autowired
    private userservice us;
    
    @PostMapping("/user")
    public ResponseEntity<user> createuser(@RequestBody user us1){
        user createduser = us.createuser(us1);
        if (createduser != null) {
            return new ResponseEntity<>(createduser, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user")
    public ResponseEntity<List<user>> getAllusers(){
        List<user> users = us.getAllusers();
        if (!users.isEmpty()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<user> getuserById(@PathVariable int userId){
        Optional<user> user1 = us.getuserById(userId);
        if (user1.isPresent()) {
            return new ResponseEntity<>(user1.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userId) {
        boolean deleted = us.deleteUser(userId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity<user> updateUser(@PathVariable int userId, @RequestBody user updatedUser) {
        updatedUser.setId(userId); // Set the user id from the path variable
        user updated = us.updateUser(updatedUser);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
