package com.track.controller;

import com.track.dao.ParentRepository;
import com.track.dao.StepsRepository;
import com.track.dao.StudentRepository;
import com.track.dao.UserRepository;
import com.track.entity.Parent;
import com.track.entity.Steps;
import com.track.entity.Student;
import com.track.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/")
public class UserController {



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;


    @Autowired
    private ParentRepository parentRepository;


    @Autowired
    private StepsRepository stepsRepository;

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
            User user_1 = new User(user.getUsername(), encodedPassword,user.getRole());

            userRepository.save(user_1);

            if(user.getRole().equals("student")){
                System.out.println("in student register");
                Student student = new Student();
                student.setName(user);
                studentRepository.save(student);
            }
            else {

                Parent parent = new Parent();
                parent.setName(user);
                parentRepository.save(parent);
            }



            return ResponseEntity.ok("{ \"email\" : "+user.getUsername()+", \"response\" : \"User Added\" }"); // fix the response
        }


    }


    @RequestMapping(value="/steps",method = RequestMethod.POST )
    public ResponseEntity<?> uploadSteps(@RequestBody Steps steps) {

        System.out.println("in steps post ");
        System.out.println(steps);
        System.out.println(steps.getDate().toString());


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        User temp = new User();
        temp.setUsername(name);

        steps.setName(temp);


        stepsRepository.save(steps);

        return ResponseEntity.ok(steps);

    }

    @RequestMapping(value="/steps",method = RequestMethod.GET )
    public ResponseEntity<?> getSteps(@RequestBody Steps steps) {







        return ResponseEntity.ok(steps);

    }

    @RequestMapping(value="/leader",method = RequestMethod.GET )
    public ResponseEntity<?> getLeader() {

        String top_5 = new String();

        top_5 = "{";
        int i =0;
        for(Map<String, Object>  e : stepsRepository.findByrank()){

            top_5 += "\"weeklySteps\":"+e.get("weeklySteps");
            top_5 += "\"username\":"+e.get("username");

            System.out.println(e.get("weeklySteps"));
            System.out.println(e.get("username"));
            i++;
            if(i==5){
                break;
            }

        }
        top_5 += "}";
        return ResponseEntity.ok(top_5);

    }


    @RequestMapping(value="/sync",method = RequestMethod.GET )
    public ResponseEntity<?> syncSteps() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        String last_time = new String();

        for(Map<String, Object>  e : stepsRepository.lastRow(name)){

            last_time = e.get("date").toString();
            System.out.println(e.get("date"));
            System.out.println(e.keySet());
        }



        return ResponseEntity.ok("{\"date\":"+last_time+"\"}");

    }
}
