package com.example.PP_3_1_2_springboot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Repository;
import com.example.PP_3_1_2_springboot.model.User;

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
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User", User.class)
                .getResultList();
    }

    @Override
    public User show(int id) {
        User userFind = entityManager.find(User.class, id);
        if (userFind == null) {
            throw new EntityNotFoundException("Пользователь не найден");
        }
        return userFind;
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public void update(int id, User user) {
        User userFind = entityManager.find(User.class, id);
        if (userFind == null) {
            throw new EntityNotFoundException("Пользователь не найден");
        }
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public void delete(int id) {
        User userFind = entityManager.find(User.class, id);
        if (userFind == null) {
            throw new EntityNotFoundException("Пользователь не найден");
        }
        entityManager.remove(show(id));
        entityManager.flush();
    }
}
