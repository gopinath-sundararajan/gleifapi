package com.example.gleif.gleifapi.config;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        final RestTemplate restTemplate = new RestTemplate(sslFactory());
        return restTemplate;
    }

    @Bean
    public HttpComponentsClientHttpRequestFactory sslFactory() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        final TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

        final SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                .loadTrustMaterial(null, acceptingTrustStrategy)
                .build();

        final SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

        final CloseableHttpClient httpClient = HttpClients.custom()
                .setMaxConnPerRoute(250)
                .setMaxConnTotal(250)
                .setSSLSocketFactory(csf)
                // during the SSL check we have also the verification of the host name,
                // this can be skipped to like this:
                .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                .build();

        final HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory();

        requestFactory.setHttpClient(httpClient);

        return requestFactory;
    }
}
