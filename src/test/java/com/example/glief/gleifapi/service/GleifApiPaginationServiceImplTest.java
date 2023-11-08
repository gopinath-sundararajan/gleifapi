package com.example.glief.gleifapi.service;

import com.example.gleif.gleifapi.config.GleifApiEndPointProperties;
import com.example.gleif.gleifapi.config.GleifAppConfig;
import com.example.gleif.gleifapi.service.api.GleifModelPopulatorService;
import com.example.gleif.gleifapi.service.impl.GleifApiPaginationServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GleifApiPaginationServiceImplTest {


    @InjectMocks
    private GleifApiPaginationServiceImpl gleifApiPaginationService;

    @Mock
    private GleifModelPopulatorService gleifModelPopulatorService;

    @Mock
    private GleifAppConfig gleifAppConfig;

    @Mock
    private GleifApiEndPointProperties gleifApiEndPointProperties;

    @Test
    public void fetchAllPaginationUrisTest() throws Exception {
        int totalRecords = 25003;
        when(gleifAppConfig.getPageSize()).thenReturn(250);
        when(gleifApiEndPointProperties.getPaginationUri()).thenReturn("https://api.gleif.org/api/v1/lei-records?page[size]=pageSize&page[number]=pageNumber");
        List<String> paginationUris = gleifApiPaginationService.fetchAllPaginationUris(totalRecords);
        Assertions.assertNotNull(paginationUris);
        Assertions.assertEquals(paginationUris.size(), 101);
    }

    @Test
    public void fetchThreePagesPaginationUrisTest() throws Exception {
        int totalRecords = 503;
        when(gleifAppConfig.getPageSize()).thenReturn(250);
        when(gleifApiEndPointProperties.getPaginationUri()).thenReturn("https://api.gleif.org/api/v1/lei-records?page[size]=pageSize&page[number]=pageNumber");
        List<String> paginationUris = gleifApiPaginationService.fetchAllPaginationUris(totalRecords);
        Assertions.assertNotNull(paginationUris);
        Assertions.assertEquals(paginationUris.size(), 3);
    }

}
