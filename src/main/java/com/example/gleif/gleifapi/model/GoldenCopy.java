package com.example.gleif.gleifapi.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.Date;

@Data
public class GoldenCopy {

    @SerializedName("publishDate")
    private Date publishDate;
}
