package com.koin.service.impl;

import com.koin.dataimport.DataImportSolr;
import com.koin.model.User;
import com.koin.repository.dao.UserRepository;
import com.koin.repository.solr.UserSolrRepository;
import com.koin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

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
        user.setLast_modified(Date.from(Instant.now()));
        return userDbRepository.saveAndFlush(user);
    }

    @Override
    public User findById(String idUser){
        return userSolrRepository.findById(Long.parseLong(idUser)).orElse(new User());
    }

}
