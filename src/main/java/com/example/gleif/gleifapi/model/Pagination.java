package com.example.gleif.gleifapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Pagination {
    private int currentPage;
    private int perPage;
    private int from;
    @JsonProperty("to")
    private int myTo;
    public int total;
    public int lastPage;
}
