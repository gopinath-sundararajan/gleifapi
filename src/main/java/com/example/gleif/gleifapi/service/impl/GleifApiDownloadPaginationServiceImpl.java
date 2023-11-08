package com.example.gleif.gleifapi.service.impl;

import com.example.gleif.gleifapi.exception.DownloadGliefApiException;
import com.example.gleif.gleifapi.model.Root;
import com.example.gleif.gleifapi.service.api.GleifApiDownloadPaginationService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
public class GleifApiDownloadPaginationServiceImpl implements GleifApiDownloadPaginationService {

    private final RestTemplate restTemplate;

    private final Gson gson = new Gson();

    public GleifApiDownloadPaginationServiceImpl(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Root> downloadAllGleifApiResults(List<String> allPagesUri) throws DownloadGliefApiException {
        List<Root> downloadAllRoots = new LinkedList<>();
        for (String uri : allPagesUri) {
            log.info("Downloading Gleif Api for Page : {} ", uri);
            String response = restTemplate.getForObject(uri, String.class);
            Root root = gson.fromJson(response, Root.class);
            downloadAllRoots.add(root);
        }
        return downloadAllRoots;
    }
}
