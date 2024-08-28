package com.flowsync.FlowSyncApp.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "flowsync_entries")
@Data
public class JournalEntry {
    @Id
    private ObjectId id;
    private String content;
    private String title;
    private LocalDateTime date;

}
