package com.tpe.config;

import com.tpe.domain.Guest;
import com.tpe.domain.Hotel;
import com.tpe.domain.Reservation;
import com.tpe.domain.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory sessionFactory;

    static {

        try {
            Configuration configuration = new Configuration().
                    configure("hibernate.cfg.xml").
                    addAnnotatedClass(Hotel.class).
                    addAnnotatedClass(Guest.class).
                    addAnnotatedClass(Reservation.class).
                    addAnnotatedClass(Room.class);

            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {

            System.err.println("Initialization of session factory is FAILED!");

        }

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutDown() {
        getSessionFactory().close();
    }

    public static void closeSession(Session session) {
        if (session != null && sessionFactory.isOpen()) {
            session.close();
        }
    }


}
