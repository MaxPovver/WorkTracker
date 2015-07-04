package com.maxpovver.worktracker;

import com.maxpovver.worktracker.entities.User;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.maxpovver.worktracker.DBUtility.getUserRepository;

/**
 * Created by admin on 03.07.15.
 */

@Component
public class Launcher {
    public static void main(String[] args) {
       // getFactory().openSession();
        List<User> user = getUserRepository().findByUsername("Test");
        System.out.print("Launched " + user);
       // getFactory().getCurrentSession().close();
    }
}
