package com.flowsync.FlowSyncApp.service;

import com.flowsync.FlowSyncApp.entity.FlowsyncEntry;
import com.flowsync.FlowSyncApp.repository.FlowSyncRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FlowSyncEntryService {

    @Autowired
    private FlowSyncRepo flowSyncRepo;

    public void saveEntry(FlowsyncEntry flowsyncEntry){
        flowSyncRepo.save(flowsyncEntry);
    }

    public List<FlowsyncEntry> getAll(){
        return flowSyncRepo.findAll();
    }

    public Optional<FlowsyncEntry> findById(ObjectId id){
        return flowSyncRepo.findById(id);
    }

    public void deleteById(ObjectId id){
        flowSyncRepo.deleteById(id);
    }
}
