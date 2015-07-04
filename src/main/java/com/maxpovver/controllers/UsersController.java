package com.maxpovver.controllers;

import com.maxpovver.worktracker.DBUtility;
import com.maxpovver.worktracker.entities.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static com.maxpovver.worktracker.DBUtility.*;

/**
 * Created by admin on 04.07.15.
 */
@RestController
public class UsersController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/users")
    public User addUser(@RequestParam(value="name") String name, @RequestParam(value="password") String password) {
       return users().save(new User(name, password));
    }

    @RequestMapping("/users")
    public List<User> getUsers(){
        List<User> res = new ArrayList<>();
        users().findAll().forEach(res::add);
        return res;
    }
}
