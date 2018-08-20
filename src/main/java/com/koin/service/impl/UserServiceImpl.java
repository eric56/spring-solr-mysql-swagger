package com.koin.service.impl;

import com.koin.model.User;
import com.koin.repository.dao.UserRepository;
import com.koin.repository.solr.UserSolrRepository;
import com.koin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserSolrRepository userSolrRepository;

    @Autowired
    private UserRepository userDbRepository;

    @Override
    public Iterable<User> findAllUsers(){
        return userSolrRepository.findAll();
    }

    @Override
    public User saveUser(User user){
        user.setLast_modified(Timestamp.from(Instant.now()));
        return userDbRepository.saveAndFlush(user);
    }

    @Override
    public User findById(String idUser){
        return userSolrRepository.findById(Long.parseLong(idUser)).orElse(new User());
    }

}
