package com.koin.controller;

import com.koin.dataimport.DataImportSolr;
import com.koin.enums.SolrCommandsEnum;
import com.koin.model.User;
import com.koin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DataImportSolr dataImportSolr;

    @RequestMapping(value = "/findAllUsers", method = RequestMethod.GET)
    public @ResponseBody Iterable<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @RequestMapping(value = "/saveUsers", method = RequestMethod.POST)
    public @ResponseBody User saveUser(@RequestBody User user){
        User usersaved =  userService.saveUser(user);
        if (usersaved.getId() != null){
            dataImportSolr.importDataByCommand(SolrCommandsEnum.DELTA_IMPORT.getCommand());
        }
        return usersaved;
    }

    @RequestMapping(value = "/findById/{idUser}", method = RequestMethod.GET)
    public @ResponseBody User findById(@PathVariable String idUser){
        return userService.findById(idUser);
    }

}
