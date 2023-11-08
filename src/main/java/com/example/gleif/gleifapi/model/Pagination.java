package com.example.gleif.gleifapi.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Pagination {

    @SerializedName("currentPage")
    private int currentPage;

    @SerializedName("perPage")
    private int perPage;

    @SerializedName("from")
    private int from;

    @SerializedName("to")
    private int to;

    @SerializedName("total")
    public int total;

    @SerializedName("lastPage")
    public int lastPage;
}
