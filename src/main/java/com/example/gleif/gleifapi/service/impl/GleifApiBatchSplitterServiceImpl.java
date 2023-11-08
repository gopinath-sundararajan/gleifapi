package com.example.gleif.gleifapi.service.impl;

import com.example.gleif.gleifapi.config.GleifAppConfig;
import com.example.gleif.gleifapi.exception.GleifApiBatchSplittingException;
import com.example.gleif.gleifapi.service.api.GleifApiBatchSplitterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
        int maxDownloadLeiRecords = gleifAppConfig.getMaxDownloadLeiRecords();
        return null;
    }
}
