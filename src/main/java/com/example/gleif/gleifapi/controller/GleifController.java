package com.example.gleif.gleifapi.controller;

import com.example.gleif.gleifapi.model.Root;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@Slf4j
@RestController
@RequestMapping(path = "/api/client")
public class GleifController {

    private final RestTemplate restTemplate;

    @Autowired
    public GleifController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(path = "/gleif")
    public String getGleifResponse() {
        String uri = "https://api.gleif.org/api/v1/lei-records";
        String response = restTemplate.getForObject(uri, String.class);
        Gson gson = new Gson();
        Root root = null;
        try {
            root = gson.fromJson(response, Root.class);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return response;
    }
}