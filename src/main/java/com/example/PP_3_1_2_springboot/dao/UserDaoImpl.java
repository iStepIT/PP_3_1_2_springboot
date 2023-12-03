package com.example.PP_3_1_2_springboot.dao;

import org.springframework.stereotype.Repository;
import com.example.PP_3_1_2_springboot.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> index() {
        return entityManager.createQuery("FROM User", User.class)
                .getResultList();
    }

    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public void update(int id, User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public void delete(int id) {
        entityManager.remove(show(id));
        entityManager.flush();
    }
}
