package com.example.gleif.gleifapi.controller;

import com.example.gleif.gleifapi.config.GleifApiEndPointProperties;
import com.example.gleif.gleifapi.model.Root;
import com.example.gleif.gleifapi.service.api.GleifApiDownloadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping(path = "/api/client")
public class GleifController {

    private final GleifApiDownloadService gleifApiDownloadService;

    private final GleifApiEndPointProperties gleifApiEndPointProperties;

    @Autowired
    public GleifController(final GleifApiDownloadService gleifApiDownloadService,
                           final GleifApiEndPointProperties gleifApiEndPointProperties) {
        this.gleifApiDownloadService = gleifApiDownloadService;
        this.gleifApiEndPointProperties = gleifApiEndPointProperties;
    }

    @GetMapping(path = "/gleif")
    public String getGleifResponse() throws Exception {
        final String uri = gleifApiEndPointProperties.getUri();
        List<Root> roots = gleifApiDownloadService.downloadGleifApiResults(uri);
        if (CollectionUtils.isEmpty(roots)) {
            return "FAILURE";
        }

        return "SUCCESS";
    }
}