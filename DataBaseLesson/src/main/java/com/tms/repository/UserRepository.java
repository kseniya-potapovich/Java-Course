package com.tms.repository;

import com.tms.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class UserRepository {
    private EntityManager entityManager = null;

    public UserRepository() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        entityManager = factory.createEntityManager();
    }

    /**
     * JPQL
     */
    public List<User> findAll() {
       /* Query query = entityManager.createNativeQuery("SELECT * FROM users", User.class);
        return query.getResultList();*/

        //JPQL
        Query query = entityManager.createQuery("FROM users", User.class); //users не таблица, а название entity
        return query.getResultList();
    }

    public User findById(Long id) {
        try {
            return entityManager.find(User.class, id);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean createUser(User user) {
        try {
            entityManager.getTransaction().begin(); //start transaction
            entityManager.persist(user); //save
            entityManager.getTransaction().commit(); //commit(fix changes)
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return false;
    }

    public boolean updateUser(User user) { //лучше делать для полей, которые часто меняются и для каждого поля свой метод, example: updateUserPassword()
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println(e);
        }
        return false;
    }

    public boolean deleteUser(Long id) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(User.class, id));
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println(e);
        }
        return false;
    }
}
