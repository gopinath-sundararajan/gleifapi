package com.example.gleif.gleifapi.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class DirectParent {

    @SerializedName("links")
    private Links links;
}
