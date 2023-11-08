package com.example.gleif.gleifapi.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Links {

    @SerializedName("first")
    private String first;

    @SerializedName("next")
    private String next;

    @SerializedName("last")
    private String last;

    @SerializedName("related")
    private String related;

    @SerializedName("reporting-exception")
    private String reportingException;

    @SerializedName("self")
    private String self;
}
