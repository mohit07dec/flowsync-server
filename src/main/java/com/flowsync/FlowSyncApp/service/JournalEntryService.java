package com.flowsync.FlowSyncApp.service;

import com.flowsync.FlowSyncApp.entity.JournalEntry;
import com.flowsync.FlowSyncApp.repository.JournalRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalRepository flowSyncRepo;

    public void saveEntry(JournalEntry flowsyncEntry){
        flowSyncRepo.save(flowsyncEntry);
    }

    public List<JournalEntry> getAll(){
        return flowSyncRepo.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return flowSyncRepo.findById(id);
    }

    public void deleteById(ObjectId id){
        flowSyncRepo.deleteById(id);
    }
}
