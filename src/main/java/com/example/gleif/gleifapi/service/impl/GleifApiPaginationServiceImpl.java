package com.example.gleif.gleifapi.service.impl;

import com.example.gleif.gleifapi.config.GleifApiEndPointProperties;
import com.example.gleif.gleifapi.config.GleifAppConfig;
import com.example.gleif.gleifapi.service.api.GleifApiPaginationService;
import com.example.gleif.gleifapi.service.api.GleifModelPopulatorService;
import com.example.gleif.gleifapi.util.GliefApiConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
public class GleifApiPaginationServiceImpl implements GleifApiPaginationService {

    private final GleifModelPopulatorService gleifApiModelPopulatorService;

    private final GleifAppConfig gleifAppConfig;

    private final GleifApiEndPointProperties gleifApiEndPointProperties;


    @Autowired
    public GleifApiPaginationServiceImpl(final GleifModelPopulatorService gleifApiModelPopulatorService,
                                         final GleifAppConfig gleifAppConfig,
                                         final GleifApiEndPointProperties gleifApiEndPointProperties) {
        this.gleifApiModelPopulatorService = gleifApiModelPopulatorService;
        this.gleifAppConfig = gleifAppConfig;
        this.gleifApiEndPointProperties = gleifApiEndPointProperties;
    }

    @Override
    public List<String> fetchAllPaginationUris(int totalRecords) throws Exception {
        int maxPageSize = gleifAppConfig.getMaxPageSize();
        int recordPerPage = totalRecords / maxPageSize;
        List<String> allPossiblePaginationURis = new LinkedList<>();
        int pageNumber = 1;
        for (int i = 0; i < totalRecords; i++) {
            if (i % maxPageSize == 0) {
                String paginationUri = gleifApiEndPointProperties.getPaginationUri();
                String replacedPageSizeUrl = paginationUri.replace(GliefApiConstants.GleifApiPaginationConstants.PAGE_SIZE, String.valueOf(maxPageSize));
                String replacedPageNumberUrl = replacedPageSizeUrl.replace(GliefApiConstants.GleifApiPaginationConstants.PAGE_NUMBER, String.valueOf(pageNumber));
                allPossiblePaginationURis.add(replacedPageNumberUrl);
                pageNumber += 1;
            }
        }
        log.info("GleifApi Total Urls to be used to download Size is : {}", allPossiblePaginationURis.size());
        return allPossiblePaginationURis;
    }
}
