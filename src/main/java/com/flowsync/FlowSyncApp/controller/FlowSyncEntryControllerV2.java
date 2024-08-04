package com.flowsync.FlowSyncApp.controller;

import com.flowsync.FlowSyncApp.entity.FlowsyncEntry;
import com.flowsync.FlowSyncApp.service.FlowSyncEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/FlowSync")
public class FlowSyncEntryControllerV2 {

    @Autowired
    private FlowSyncEntryService flowsyncEntryService;

    @PostMapping
    public ResponseEntity<FlowsyncEntry> createFlowSyncEntry(@RequestBody FlowsyncEntry newEntry){
        try {
            newEntry.setDate(LocalDateTime.now());
            flowsyncEntryService.saveEntry(newEntry);
            return new ResponseEntity<>(newEntry, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public List<FlowsyncEntry> getAll(){
        return flowsyncEntryService.getAll();
    }

    @GetMapping("id/{queryId}")
    public ResponseEntity<FlowsyncEntry> getById(@PathVariable ObjectId queryId){
        Optional<FlowsyncEntry> fsyncEntry = flowsyncEntryService.findById(queryId);
        if(fsyncEntry.isPresent()){
            return new ResponseEntity<>(fsyncEntry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{queryId}")
    public ResponseEntity<?> deleteById(@PathVariable ObjectId queryId){
        flowsyncEntryService.deleteById(queryId);
        return new ResponseEntity<>(queryId, HttpStatus.NO_CONTENT);
    }

    @PutMapping("id/{queryId}")
    public ResponseEntity<?> UpdateById(@PathVariable ObjectId queryId, @RequestBody FlowsyncEntry newEntry){
        FlowsyncEntry old = flowsyncEntryService.findById(queryId).orElse(null);
        if(old != null){
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
            flowsyncEntryService.saveEntry(old);
            return new ResponseEntity<>(old, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
