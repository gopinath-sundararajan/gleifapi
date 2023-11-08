package com.example.gleif.gleifapi.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class UltimateParent {

    @SerializedName("links")
    private Links links;
}
