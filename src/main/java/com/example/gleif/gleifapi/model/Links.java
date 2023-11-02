package com.example.gleif.gleifapi.model;

import lombok.Data;

@Data
public class Links {
    private String first;
    private String next;
    private String last;
    private String related;
    private String reportingException;
    private String relationshipRecord;
    private String leiRecord;
    private String self;
}
