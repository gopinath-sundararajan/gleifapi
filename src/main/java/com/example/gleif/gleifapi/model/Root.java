package com.example.gleif.gleifapi.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class Root {

    @SerializedName("meta")
    private Meta meta;

    @SerializedName("links")
    private Links links;

    @SerializedName("data")
    private List<Datum> data;
}
