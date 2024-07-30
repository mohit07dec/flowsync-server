package com.flowsync.FlowSyncApp.controller;

import com.flowsync.FlowSyncApp.entity.FlowsyncEntry;
import com.flowsync.FlowSyncApp.service.FlowSyncEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/FlowSync")
public class FlowSyncEntryControllerV2 {

    @Autowired
    private FlowSyncEntryService flowsyncEntryService;

    @PostMapping
    public boolean createFlowSyncEntry(@RequestBody FlowsyncEntry newEntry){
        flowsyncEntryService.saveEntry(newEntry);
        return true;
    }

    @GetMapping
    public List<FlowsyncEntry> getAll(){
        return null;
    }

    @GetMapping("id/{queryId}")
    public FlowsyncEntry getById(@PathVariable long queryId){
        return null;
    }

    @DeleteMapping("id/{queryId}")
    public FlowsyncEntry deleteById(@PathVariable long queryId){
        return null;
    }

    @PutMapping("id/{queryId}")
    public boolean UpdateById(@PathVariable long queryId, @RequestBody FlowsyncEntry newEntry){
        return true;
    }

}
