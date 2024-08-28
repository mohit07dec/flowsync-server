package com.flowsync.FlowSyncApp.service;

import com.flowsync.FlowSyncApp.entity.User;
import com.flowsync.FlowSyncApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public void saveEntry(User user) {
        userRepo.save(user);
    }
    public List<User> getAll(){
        return userRepo.findAll();
    }

    public Optional<User> findById(ObjectId id){
        return userRepo.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepo.deleteById(id);
    }

    public User findByUserName(String userName) {
        return userRepo.findByUserName(userName);
    }
}
