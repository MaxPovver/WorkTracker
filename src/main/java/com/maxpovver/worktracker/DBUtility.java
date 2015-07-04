package com.maxpovver.worktracker;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by admin on 04.07.15.
 */
public class DBUtility {
    private static ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
    private static SessionFactory factory = null;
    public static SessionFactory getFactory() {
        if (factory == null) {
            try {
                factory = (SessionFactory) ctx.getBean("sessionFactory");
            } catch (Throwable ex) {
                System.err.println("Failed to create sessionFactory object." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return factory;
    }
}
