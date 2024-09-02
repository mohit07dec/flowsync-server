package com.flowsync.FlowSyncApp.repository;

import com.flowsync.FlowSyncApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId>{
}
