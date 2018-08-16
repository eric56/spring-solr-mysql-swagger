package com.koin.service;

import com.koin.model.User;

public interface UserService {

    public Iterable<User> findAllUsers();

    public User saveUser(User user);

    public User findById(String idUser);

}
