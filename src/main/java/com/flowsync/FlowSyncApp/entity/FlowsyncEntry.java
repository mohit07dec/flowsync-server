package com.flowsync.FlowSyncApp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "flowsync_entries")
@Data
public class FlowsyncEntry {
    @Id
    private ObjectId id;
    private String content;
    private String title;
    private LocalDateTime date;

}
