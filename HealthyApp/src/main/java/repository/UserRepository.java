package repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import models.User;

import java.util.List;

public class UserRepository {
    private EntityManager entityManager = null;

    public UserRepository() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        entityManager = factory.createEntityManager();
    }

    public List<User> getAll() {
        Query query = entityManager.createQuery("FROM users ", User.class);
        return query.getResultList();
    }

    public User getById(Long id) {
        try {
            return entityManager.find(User.class, id);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean updateUser(User user) {
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

    public boolean addUser(User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
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
