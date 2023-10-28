package com.example.gleif.gleifapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


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
        return response;
    }

}
