package com.koin.service.impl;

import com.koin.dataimport.DataImportSolr;
import com.koin.model.User;
import com.koin.repository.dao.UserRepository;
import com.koin.repository.solr.UserSolrRepository;
import com.koin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserSolrRepository userSolrRepository;

    @Autowired
    private UserRepository userDbRepository;

    @Autowired
    private DataImportSolr dataImportSolr;

    @Override
    public Iterable<User> findAllUsers(){
        return userSolrRepository.findAll();
    }

    @Override
    public User saveUser(User user){
        user.setLast_modified(new Date());
        User userSaved = userDbRepository.saveAndFlush(user);
        dataImportSolr.importDataByCommand("delta-import");
        return userSaved;
    }

    @Override
    public User findById(String idUser){
        return userSolrRepository.findById(idUser).orElse(new User());
    }

}
