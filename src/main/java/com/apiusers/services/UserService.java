package com.apiusers.services;

import com.apiusers.models.UserModel;
import com.apiusers.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Override
    public ArrayList<UserModel> getUsers() {
       return (ArrayList<UserModel>) userRepository.findAll();
    }

    @Override
    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<UserModel> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserModel updateUserById(UserModel request, Long id) {
        UserModel userModel = userRepository.findById(id).orElse(null);

        userModel.setFirstName(request.getFirstName());
        userModel.setLastName(request.getLastName());
        userModel.setEmail(request.getEmail());

        return this.saveUser(userModel);
    }

    @Override
    public Boolean deleteUserById(Long id) {
        try {
            userRepository.deleteById(id);
            return true;

        }catch (Exception exception){
            return false;
        }
    }
}
