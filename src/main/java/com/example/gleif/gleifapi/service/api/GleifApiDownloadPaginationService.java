package com.example.gleif.gleifapi.service.api;

import com.example.gleif.gleifapi.exception.DownloadGliefApiException;
import com.example.gleif.gleifapi.exception.GleifApiBatchSplittingException;
import com.example.gleif.gleifapi.model.Root;

import java.util.List;

public interface GleifApiDownloadPaginationService {

    List<Root> downloadAllGleifApiResults(List<String> allPagesUri) throws DownloadGliefApiException, GleifApiBatchSplittingException;
}
