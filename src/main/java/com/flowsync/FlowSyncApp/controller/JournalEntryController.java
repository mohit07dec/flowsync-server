package com.flowsync.FlowSyncApp.controller;

import com.flowsync.FlowSyncApp.entity.JournalEntry;
import com.flowsync.FlowSyncApp.entity.User;
import com.flowsync.FlowSyncApp.service.JournalEntryService;
import com.flowsync.FlowSyncApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;
    @Autowired
    private UserService userService;

    @GetMapping("/{userName}")
    public ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable String userName) {
        // ? -> List<JournalEntry>
        User user = userService.findByUserName(userName);
        List<JournalEntry> all = user.getJournalEntries();
        if(all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{userName}")
    public ResponseEntity<JournalEntry> createJournalEntry(@PathVariable String userName, @RequestBody JournalEntry myEntry){
        try {
            journalEntryService.saveEntry(myEntry, userName);
            return new ResponseEntity<>(myEntry, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{queryId}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId queryId){
        Optional<JournalEntry> journalEntry = journalEntryService.findById(queryId);
        if(journalEntry.isPresent()){
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{userName}/{queryId}")
    public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId queryId, @PathVariable String userName){
        journalEntryService.deleteById(queryId, userName);
        return new ResponseEntity<>(queryId, HttpStatus.NO_CONTENT);
    }

    @PutMapping("id/{userName}/{queryId}")
    public ResponseEntity<?> UpdateJournalEntryById(
            @PathVariable ObjectId queryId,
            @RequestBody JournalEntry newEntry,
            @PathVariable String userName
    ){
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
