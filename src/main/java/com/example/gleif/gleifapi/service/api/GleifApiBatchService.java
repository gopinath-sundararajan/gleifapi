package com.example.gleif.gleifapi.service.api;

import com.example.gleif.gleifapi.model.Root;

import java.util.List;

public interface GleifApiBatchService {
    public List<Root> executeBatch(List<String> batchPaginationUris);
}
