package com.anlu.secrity.dao;

import com.anlu.secrity.model.User;

import java.util.List;

public interface UserDao {
    User findById(int id);

    User findBySSO(String sso);

    void save(User user);

    void deleteBySSO(String sso);

    List<User> findAllUsers();
}
