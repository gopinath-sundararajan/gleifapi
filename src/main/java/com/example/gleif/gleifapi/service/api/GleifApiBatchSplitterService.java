package com.example.gleif.gleifapi.service.api;

import com.example.gleif.gleifapi.exception.GleifApiBatchSplittingException;

import java.util.List;
import java.util.Map;

public interface GleifApiBatchSplitterService {
    Map<Integer, List<String>> splitBatchesByMaxDownloadableLeiRecords(List<String> allPagesUri) throws GleifApiBatchSplittingException;
}
