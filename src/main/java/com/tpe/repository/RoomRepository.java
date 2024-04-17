package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.domain.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoomRepository {
    //todo: roomRepoda save, findById, findAll

    private Session session;

    public void save(Room room) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(room);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
    }

    public Room findById(Long id) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();

            return session.get(Room.class, id);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

    public List<Room> findAll() {
        try {
            session = HibernateUtils.getSessionFactory().openSession();

            String hql = "FROM Room";
            return session.createQuery(hql, Room.class).getResultList();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }
}
