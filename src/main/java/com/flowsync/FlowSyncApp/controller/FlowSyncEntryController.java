package com.flowsync.FlowSyncApp.controller;

import com.flowsync.FlowSyncApp.entity.FlowSyncEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/FlowSync")
public class FlowSyncEntryController {

    private Map<Long, FlowSyncEntry> flowSyncEntries = new HashMap<>();

    @GetMapping
    public List<FlowSyncEntry> getAll(){
        return new ArrayList<>(flowSyncEntries.values());
    }

    @GetMapping("id/{queryId}")
    public FlowSyncEntry getById(@PathVariable long queryId){
        return flowSyncEntries.get(queryId);
    }

    @DeleteMapping("id/{queryId}")
    public FlowSyncEntry deleteById(@PathVariable long queryId){
        return flowSyncEntries.remove(queryId);
    }
    @PutMapping("id/{queryId}")
    public boolean UpdateById(@PathVariable long queryId, @RequestBody FlowSyncEntry newEntry){
        flowSyncEntries.put(newEntry.getId(), newEntry);
        return true;
    }

    @PostMapping
    public boolean createFlowSyncEntry(@RequestBody FlowSyncEntry newEntry){
        flowSyncEntries.put(newEntry.getId(), newEntry);
        return true;
    }
}
