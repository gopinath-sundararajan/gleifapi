package com.example.gleif.gleifapi.model;

import lombok.Data;

@Data
public class Datum {
    private String type;
    private String id;
    private Attributes attributes;
    private Relationships relationships;
    private Links links;
}
