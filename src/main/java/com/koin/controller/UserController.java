package com.koin.controller;

import com.koin.service.UserService;
import com.koin.service.impl.UserServiceImpl;
import com.koin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findAllUsers", method = RequestMethod.GET)
    public @ResponseBody Iterable<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @RequestMapping(value = "/saveUsers", method = RequestMethod.POST)
    public @ResponseBody User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/findById/{idUser}", method = RequestMethod.GET)
    public @ResponseBody User findById(@PathVariable String idUser){
        return userService.findById(idUser);
    }

}
