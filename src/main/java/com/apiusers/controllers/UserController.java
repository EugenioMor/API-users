package com.apiusers.controllers;

import com.apiusers.models.UserModel;
import com.apiusers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping("/create")
    public UserModel saveUser(@RequestBody UserModel user){
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public Optional<UserModel> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/edit/{id}")
    public UserModel updateUserById(@RequestBody UserModel request, @PathVariable Long id){
        return userService.updateUserById(request, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUserById(@PathVariable Long id){
        Boolean ok = userService.deleteUserById(id);

        if (ok){
            return "User with id " + id + " deleted!";
        }
        else {
            return "The user with id " + id + " does not exist";
        }
    }


}
