package com.tms.repository;

import com.tms.model.User;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class UserRepository {
    private Session session = null;
    CriteriaBuilder cb = null;

    public UserRepository() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
        cb = session.getCriteriaBuilder();
    }

    public List<User> findAll() {
        /*Query<User> query = session.createQuery("FROM users", User.class); //users не таблица, а название entity
        return query.getResultList();*/

        try {
            CriteriaQuery<User> cq = cb.createQuery(User.class);
            Root<User> root = cq.from(User.class);
            cq.select(root);
            return session.createQuery(cq).getResultList();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public User findById(Long id) {
        try {
            CriteriaQuery<User> cq = cb.createQuery(User.class);
            Root<User> root = cq.from(User.class);
            cq.select(root).where(cb.equal(root.get("id"), id));
            return session.createQuery(cq).getSingleResult();
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
           /* session.getTransaction().begin();
            session.merge(user);
            session.getTransaction().commit();*/

            CriteriaUpdate<User> criteria = cb.createCriteriaUpdate(User.class);
            Root<User> root = criteria.from(User.class);

            criteria.set("username", user.getUsername());
            criteria.set("user_password", user.getUserPassword());
            criteria.set("created", user.getCreated());
            criteria.set("changed", user.getChanged());
            criteria.set("age", user.getAge());

            criteria.where(cb.equal(root.get("id"), user.getId()));

            session.getTransaction().begin();
            session.createMutationQuery(criteria);
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
           /* session.getTransaction().begin();
            session.remove(session.get(User.class, id));
            session.getTransaction().commit();*/
            CriteriaDelete<User> criteria = cb.createCriteriaDelete(User.class);
            Root<User> root = criteria.from(User.class);
            criteria.where(cb.equal(root.get("id"), id));
            session.getTransaction().begin();
            session.createMutationQuery(criteria).executeUpdate();
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e);
        }
        return false;
    }
}
