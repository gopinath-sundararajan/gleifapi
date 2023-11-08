package com.example.gleif.gleifapi.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class LeiIssuer {

    @SerializedName("links")
    private Links links;
}
