package com.example.gleif.gleifapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties("gleif-appconfig")
public class GleifAppConfig {
    private int maxPageSize;
    private int maxDownloadLeiRecords;
}