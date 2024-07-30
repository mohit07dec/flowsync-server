package com.flowsync.FlowSyncApp.service;

import com.flowsync.FlowSyncApp.entity.FlowsyncEntry;
import com.flowsync.FlowSyncApp.repository.FlowSyncRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlowSyncEntryService {

    @Autowired
    private FlowSyncRepo flowSyncRepo;

    public void saveEntry(FlowsyncEntry flowsyncEntry){
        flowSyncRepo.save(flowsyncEntry);
    }
}
