package com.apiusers.services;

import com.apiusers.models.UserModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Optional;

public interface IUserService {

    public ArrayList<UserModel> getUsers();

    public UserModel saveUser(UserModel user);

    public Optional<UserModel> getUserById(Long id);

    public UserModel updateUserById(UserModel request, Long id);

    public Boolean deleteUserById(Long id);
}
