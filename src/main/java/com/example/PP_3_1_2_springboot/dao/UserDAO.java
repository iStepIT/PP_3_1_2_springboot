package com.example.PP_3_1_2_springboot.dao;

import com.example.PP_3_1_2_springboot.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    User show(int id);

    void save(User user);

    void update(int id, User user);

    void delete(int id);
}
