package com.example.PP_3_1_2_springboot.service;

import com.example.PP_3_1_2_springboot.model.User;

import java.util.List;

public interface UserService {
    List<User> index ();
    User show(int id);
    void save(User user);
    void update(int id, User user);
    void delete(int id);

}
