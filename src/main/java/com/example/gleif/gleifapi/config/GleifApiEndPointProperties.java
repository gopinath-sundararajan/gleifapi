package com.example.gleif.gleifapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties("gleif-endpoints")
public class GleifApiEndPointProperties {
    private String uri;
    private String paginationUri;
}
