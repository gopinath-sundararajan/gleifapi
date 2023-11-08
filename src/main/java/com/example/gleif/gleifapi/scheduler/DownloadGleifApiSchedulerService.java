package com.example.gleif.gleifapi.scheduler;

import com.example.gleif.gleifapi.config.GleifApiEndPointProperties;
import com.example.gleif.gleifapi.model.Root;
import com.example.gleif.gleifapi.service.api.GleifApiDownloadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class DownloadGleifApiSchedulerService {

    private final GleifApiDownloadService gleifApiDownloadService;

    private final GleifApiEndPointProperties gleifApiEndPointProperties;

    @Autowired
    public DownloadGleifApiSchedulerService(final GleifApiEndPointProperties gleifApiEndPointProperties, final GleifApiDownloadService gleifApiDownloadService) {
        this.gleifApiEndPointProperties = gleifApiEndPointProperties;
        this.gleifApiDownloadService = gleifApiDownloadService;
    }

    @Scheduled(fixedDelay = 1000000000, initialDelay = 1000)
    public void scheduleGleifApiDownload() throws Exception {
        final String uri = gleifApiEndPointProperties.getUri();
        List<Root> roots = gleifApiDownloadService.downloadGleifApiResults(uri);
        log.info("Finished downloading the all the Gleif Api");
    }
}
