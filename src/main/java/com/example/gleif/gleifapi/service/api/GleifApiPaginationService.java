package com.example.gleif.gleifapi.service.api;

import com.example.gleif.gleifapi.model.Root;

import java.net.URL;
import java.util.List;

public interface GleifApiPaginationService {
    List<String> fetchAllPaginationUris(int totalRecords) throws Exception;
}
