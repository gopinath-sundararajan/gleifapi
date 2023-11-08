package com.example.gleif.gleifapi.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Datum {

    @SerializedName("type")
    private String type;

    @SerializedName("id")
    private String id;

    @SerializedName("attributes")
    private Attributes attributes;

    @SerializedName("relationships")
    private Relationships relationships;

    @SerializedName("links")
    private Links links;
}
