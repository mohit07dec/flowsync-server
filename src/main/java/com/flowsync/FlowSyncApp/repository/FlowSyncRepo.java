package com.flowsync.FlowSyncApp.repository;

import com.flowsync.FlowSyncApp.entity.FlowsyncEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FlowSyncRepo extends MongoRepository<FlowsyncEntry, String>{
}
