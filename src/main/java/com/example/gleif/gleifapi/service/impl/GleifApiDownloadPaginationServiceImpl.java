package com.example.gleif.gleifapi.service.impl;

import com.example.gleif.gleifapi.exception.DownloadGliefApiException;
import com.example.gleif.gleifapi.exception.GleifApiBatchSplittingException;
import com.example.gleif.gleifapi.model.Root;
import com.example.gleif.gleifapi.service.api.GleifApiBatchService;
import com.example.gleif.gleifapi.service.api.GleifApiBatchSplitterService;
import com.example.gleif.gleifapi.service.api.GleifApiDownloadPaginationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class GleifApiDownloadPaginationServiceImpl implements GleifApiDownloadPaginationService {

    private final GleifApiBatchSplitterService gleifApiBatchSplitterService;

    private final GleifApiBatchService gleifApiBatchService;

    @Autowired
    public GleifApiDownloadPaginationServiceImpl(final GleifApiBatchSplitterService gleifApiBatchSplitterService, final GleifApiBatchService gleifApiBatchService) {
        this.gleifApiBatchSplitterService = gleifApiBatchSplitterService;
        this.gleifApiBatchService = gleifApiBatchService;
    }

    @Override
    public List<Root> downloadAllGleifApiResults(List<String> allPagesUri) throws DownloadGliefApiException, GleifApiBatchSplittingException {
        List<Root> fullyDownloadedGleifResults = new LinkedList<>();
        Map<Integer, List<String>> integerListMap = gleifApiBatchSplitterService.splitBatchesByMaxDownloadableLeiRecords(allPagesUri);
        Set<Integer> batches = integerListMap.keySet();
        //Iterate through batches
        for (Integer batch : batches) {
            final List<String> batchPaginationUris = integerListMap.get(batch);
            log.info("Download Batch No : {}", batch);
            List<Root> batchGleifApiResults = gleifApiBatchService.executeBatch(batchPaginationUris);
            try {
                TimeUnit.MINUTES.sleep(3);
                log.info("Waiting a minute to download for next Batch ");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            fullyDownloadedGleifResults.addAll(batchGleifApiResults);
        }
        return fullyDownloadedGleifResults;
    }
}
