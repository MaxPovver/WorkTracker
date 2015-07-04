package com.maxpovver.worktracker;

import com.maxpovver.worktracker.entities.User;
import com.maxpovver.worktracker.respositories.UserRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 04.07.15.
 */

@Component
public class DBUtility {

    public static UserRepository getUserRepository() {
        return (UserRepository)ctx.getBean("userRepository");
    }

    public static ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
    private static SessionFactory factory = null;
    public static SessionFactory getFactory() {
        if (factory == null) {
            try {
                factory = (SessionFactory) ctx.getBean("mySessionFactory");
            } catch (Throwable ex) {
                System.err.println("Failed to create sessionFactory object." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return factory;
    }
}
