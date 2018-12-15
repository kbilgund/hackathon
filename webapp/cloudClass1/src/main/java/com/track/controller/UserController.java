package com.track.controller;

import com.track.dao.UserRepository;
import com.track.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;



@RestController
@RequestMapping("/")
public class UserController {



    @Autowired
    private UserRepository userRepository;



    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;






    @RequestMapping(method = RequestMethod.GET )
    public ResponseEntity<?> getAllUsers(){

        LocalDateTime currentTime = LocalDateTime.now();

        return ResponseEntity.ok(currentTime);
    }

    @RequestMapping(value="/health",method = RequestMethod.GET )
    public ResponseEntity<?> health(){

        LocalDateTime currentTime = LocalDateTime.now();

        return ResponseEntity.ok(currentTime);
    }

    @RequestMapping(value="/register",method = RequestMethod.POST )
    public ResponseEntity<?> createUser(@RequestBody User user) {

        System.out.println("debug"+user.getUsername());
        if(userRepository.existsById(user.getUsername()) == true){
            System.out.println("User exists");
            return ResponseEntity.ok("{  \"response\" : \"User already exists!!!\" }"); // fix the response

        }
        else {
            String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
            User user_1 = new User(user.getUsername(), encodedPassword,"ADMIN");
            userRepository.save(user_1);
            return ResponseEntity.ok("{ \"email\" : "+user.getUsername()+", \"response\" : \"User Added\" }"); // fix the response
        }


    }

}
