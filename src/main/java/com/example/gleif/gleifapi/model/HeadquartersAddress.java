package com.example.gleif.gleifapi.model;

import lombok.Data;

import java.util.List;

@Data
public class HeadquartersAddress {
    private String language;
    private List<String> addressLines;
    private Object addressNumber;
    private Object addressNumberWithinBuilding;
    private String mailRouting;
    private String city;
    private String region;
    private String country;
    private String postalCode;

}
