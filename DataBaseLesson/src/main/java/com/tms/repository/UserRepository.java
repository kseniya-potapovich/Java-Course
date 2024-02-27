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
        /*Query<User> query = session.createQuery("FROM users", User.class); //users не таблица, а название entity
        return query.getResultList();*/

        Query<User> query = session.createQuery("from users", User.class);
        return query.getResultList();
    }

    public User findById(Long id) {
        try {
            Query<User> query = session.createQuery("from users u where u.id = :userId", User.class);
            query.setParameter("userId", id);
            return query.getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    //add lines from another table, нельзя создать юзера, можно только достать его из другой таблицы и вставить в нашу)
    public boolean createUser(User user) {
        try {
            Query<User> query = session.createQuery("insert into users (username, userPassword, created, changed, age) " +
                    "select username, userPassword, created, changed, age from  users_second_table");
            session.getTransaction().begin();
            int result = query.executeUpdate();
            session.getTransaction().commit();
            return result != 0;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e);
        }
        return false;
    }

    public boolean updateUser(User user) { //лучше делать для полей, которые часто меняются и для каждого поля свой метод, example: updateUserPassword()
        try {
           /* session.getTransaction().begin();
            session.merge(user);
            session.getTransaction().commit();*/

            Query<User> query = session.createQuery("update users  set username =:un, userPassword=:up, created=:cr,changed=:ch, age=:age where id=:userId", User.class);
            query.setParameter("un", user.getUsername());
            query.setParameter("up", user.getUserPassword());
            query.setParameter("cr", user.getCreated());
            query.setParameter("ch", user.getChanged());
            query.setParameter("age", user.getAge());
            query.setParameter("userId", user.getId());

            session.getTransaction().begin();
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e);
        }
        return false;
    }

    public boolean deleteUser(Long id) {
        try {
           /* session.getTransaction().begin();
            session.remove(session.get(User.class, id));
            session.getTransaction().commit();*/

            Query<User> query = session.createQuery("delete from users where id=:userId", User.class);
            query.setParameter("userId", id);

            session.getTransaction().begin();
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e);
        }
        return false;
    }
}