package com.flowsync.FlowSyncApp.controller;

import com.flowsync.FlowSyncApp.entity.JournalEntry;
import com.flowsync.FlowSyncApp.service.JournalEntryService;
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
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @PostMapping
    public ResponseEntity<JournalEntry> createFlowSyncEntry(@RequestBody JournalEntry newEntry){
        try {
            newEntry.setDate(LocalDateTime.now());
            journalEntryService.saveEntry(newEntry);
            return new ResponseEntity<>(newEntry, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();
    }

    @GetMapping("id/{queryId}")
    public ResponseEntity<JournalEntry> getById(@PathVariable ObjectId queryId){
        Optional<JournalEntry> journalEntry = journalEntryService.findById(queryId);
        if(journalEntry.isPresent()){
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{queryId}")
    public ResponseEntity<?> deleteById(@PathVariable ObjectId queryId){
        journalEntryService.deleteById(queryId);
        return new ResponseEntity<>(queryId, HttpStatus.NO_CONTENT);
    }

    @PutMapping("id/{queryId}")
    public ResponseEntity<?> UpdateById(@PathVariable ObjectId queryId, @RequestBody JournalEntry newEntry){
        JournalEntry old = journalEntryService.findById(queryId).orElse(null);
        if(old != null){
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
            journalEntryService.saveEntry(old);
            return new ResponseEntity<>(old, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
