package com.example.gleif.gleifapi.service.impl;

import com.example.gleif.gleifapi.config.GleifAppConfig;
import com.example.gleif.gleifapi.exception.GleifApiBatchSplittingException;
import com.example.gleif.gleifapi.service.api.GleifApiBatchSplitterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class GleifApiBatchSplitterServiceImpl implements GleifApiBatchSplitterService {

    private final GleifAppConfig gleifAppConfig;

    public GleifApiBatchSplitterServiceImpl(final GleifAppConfig gleifAppConfig) {
        this.gleifAppConfig = gleifAppConfig;
    }

    @Override
    public Map<Integer, List<String>> splitBatchesByMaxDownloadableLeiRecords(List<String> allPagesUri) throws GleifApiBatchSplittingException {
        int maxDownloadLeiRecordsPerSession = gleifAppConfig.getMaxDownloadLeiRecordsPerSession();
        int maxPageSize = gleifAppConfig.getMaxPageSize();
        Map<Integer, List<String>> batchPagesUriMap = new HashMap<>();
        int totalPages = allPagesUri.size();
        int batch = 1;
        int noOfPagesForASingleBatch = maxDownloadLeiRecordsPerSession / maxPageSize;
        List<String> batcheUris = new LinkedList();
        int page = 1;
        for (String pageUri : allPagesUri) {
            batcheUris.add(pageUri);
            if (page % noOfPagesForASingleBatch == 0) {

                batchPagesUriMap.put(batch++, batcheUris);
                batcheUris = new LinkedList<>();
                page = 1;
            } else {
                page += 1;
            }
        }
        //final Batch
        batchPagesUriMap.put(batch, batcheUris);
        return batchPagesUriMap;
    }
}
