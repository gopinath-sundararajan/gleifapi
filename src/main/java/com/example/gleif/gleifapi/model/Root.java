package com.example.gleif.gleifapi.model;

import lombok.Data;

import java.util.List;

@Data
public class Root {
    private Meta meta;
    private Links links;
    private List<Datum> data;
}
