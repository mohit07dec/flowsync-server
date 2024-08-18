package com.flowsync.FlowSyncApp.repository;

import com.flowsync.FlowSyncApp.entity.FlowsyncEntry;
import com.flowsync.FlowSyncApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, ObjectId>{

    User findByUserName(String userName);
}
