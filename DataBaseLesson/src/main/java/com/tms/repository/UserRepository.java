package com.tms.repository;

import com.tms.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class UserRepository {
    private Session session = null;

    public UserRepository() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
    }

    public List<User> findAll() {
        Query<User> query = session.createQuery("FROM users", User.class); //users не таблица, а название entity
        return query.getResultList();
    }

    public User findById(Long id) {
        try {
            return session.get(User.class, id);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean createUser(User user) {
        try {
            session.getTransaction().begin();
            session.persist(user);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e);
        }
        return false;
    }

    public boolean updateUser(User user) { //лучше делать для полей, которые часто меняются и для каждого поля свой метод, example: updateUserPassword()
        try {
            session.getTransaction().begin();
            session.merge(user);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e);
        }
        return false;
    }

    public boolean deleteUser(Long id) {
        try {
            session.getTransaction().begin();
            session.remove(session.get(User.class, id));
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e);
        }
        return false;
    }
}
