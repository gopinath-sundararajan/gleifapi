package com.example.gleif.gleifapi.service.impl;

import com.example.gleif.gleifapi.model.Root;
import com.example.gleif.gleifapi.service.api.GleifApiBatchService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
public class GleifApiBatchServiceImpl implements GleifApiBatchService {

    private final RestTemplate restTemplate;

    private final Gson gson = new Gson();

    public GleifApiBatchServiceImpl(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Root> executeBatch(List<String> batchPaginationUris) {
        List<Root> downloadAllRoots = new LinkedList<>();
        for (String currentBatchUri : batchPaginationUris) {
            log.info("Downloading the page for URI :{} ", currentBatchUri);
            String response = restTemplate.getForObject(currentBatchUri, String.class);
            Root root = gson.fromJson(response, Root.class);
            downloadAllRoots.add(root);
        }
        return downloadAllRoots;
    }
}
