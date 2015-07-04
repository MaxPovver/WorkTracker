package com.maxpovver.worktracker;

import com.maxpovver.worktracker.entities.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by admin on 03.07.15.
 */
public class Launcher {

    public static void main(String[] args) {
        Long userID1 = addUser("Test", "qwerty");
        Session session = DBUtility.getFactory().openSession();
        User user1 = (User)session.get(User.class, userID1);
        System.out.print("Launched " + user1);
    }
    public static Long addUser(String username, String password){
        Session session = DBUtility.getFactory().openSession();
        Transaction tx = null;
        Long userID = null;
        try{
            tx = session.beginTransaction();
            User user = new User(username, password);
            userID = (Long)session.save(user);
            session.save(new Job("Fund",40000.0d,"rub",user));
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return userID;
    }
}
