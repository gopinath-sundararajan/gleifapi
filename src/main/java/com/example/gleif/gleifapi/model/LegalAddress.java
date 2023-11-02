package com.example.gleif.gleifapi.model;

import lombok.Data;

import java.util.List;

@Data
public class LegalAddress {
    private String language;
    private List<String> addressLines;
    private Object addressNumber;
    private Object addressNumberWithinBuilding;
    private String mailRouting;
    public String city;
    public String region;
    public String country;
    public String postalCode;
}
