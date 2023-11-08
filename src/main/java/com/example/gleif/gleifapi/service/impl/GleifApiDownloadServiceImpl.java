package com.example.gleif.gleifapi.service.impl;

import com.example.gleif.gleifapi.exception.DownloadGliefApiException;
import com.example.gleif.gleifapi.model.Meta;
import com.example.gleif.gleifapi.model.Pagination;
import com.example.gleif.gleifapi.model.Root;
import com.example.gleif.gleifapi.service.api.GleifApiDownloadPaginationService;
import com.example.gleif.gleifapi.service.api.GleifApiDownloadService;
import com.example.gleif.gleifapi.service.api.GleifApiPaginationService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class GleifApiDownloadServiceImpl implements GleifApiDownloadService {

    private final RestTemplate restTemplate;

    private final GleifApiDownloadPaginationService gleifApiDownloadPaginationService;
    private final GleifApiPaginationService gleifApiPaginationService;

    @Autowired
    public GleifApiDownloadServiceImpl(final RestTemplate restTemplate, final GleifApiPaginationService gleifApiPaginationService,
                                       final GleifApiDownloadPaginationService gleifApiDownloadPaginationService) {
        this.restTemplate = restTemplate;
        this.gleifApiPaginationService = gleifApiPaginationService;
        this.gleifApiDownloadPaginationService = gleifApiDownloadPaginationService;
    }

    @Override
    public List<Root> downloadGleifApiResults(String uri) throws DownloadGliefApiException {
        String response = restTemplate.getForObject(uri, String.class);
        List<Root> downloadedGliefApiResults = new ArrayList<>();
        Root root = null;
        try {
            root = new Gson().fromJson(response, Root.class);
            if (Objects.nonNull(root)) {
                final Meta meta = root.getMeta();
                final Pagination pagination = meta.getPagination();
                if (Objects.nonNull(pagination)) {
                    int total = pagination.getTotal();
                    List<String> allPaginationUris = gleifApiPaginationService.fetchAllPaginationUris(total);
                    List<Root> allRootDownloads = gleifApiDownloadPaginationService.downloadAllGleifApiResults(allPaginationUris);
                    downloadedGliefApiResults.addAll(allRootDownloads);
                }
            }
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return downloadedGliefApiResults;
    }
}