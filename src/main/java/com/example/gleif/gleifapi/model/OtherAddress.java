package com.example.gleif.gleifapi.model;

import lombok.Data;

import java.util.List;

@Data
public class OtherAddress {
    private String fieldType;
    private String language;
    private String type;
    private List<String> addressLines;
    private String city;
    private String region;
    private String country;
    public String postalCode;
    public String mailRouting;
}
