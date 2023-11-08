package com.example.gleif.gleifapi.service.api;

import com.example.gleif.gleifapi.exception.DownloadGliefApiException;
import com.example.gleif.gleifapi.model.Root;

import java.util.List;

public interface GleifApiDownloadService {

    List<Root> downloadGleifApiResults(String uri) throws DownloadGliefApiException;
}
