package com.vk.pit.kite.commons.web;

import com.vk.pit.kite.commons.KiteConstants;
import com.vk.pit.kite.commons.KiteProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class KiteAuthWebClientConfig {

    private final KiteProperties kiteProperties;
    public static final String KITE_API_BEAN_ID = "kiteApiWebClient";
    public static final String KITE_APP_BEAN_ID = "kiteAppWebClient";


    public KiteAuthWebClientConfig(KiteProperties kiteProperties) {
        this.kiteProperties = kiteProperties;
    }

    @Bean(KiteAuthWebClientConfig.KITE_API_BEAN_ID)
    public WebClient kiteApiWebClient() {
        return WebClient.builder()
                .baseUrl(kiteProperties.getHost().getApiHost())
                .defaultHeader(KiteConstants.VERSION_KEY, kiteProperties.getVersion())
                .build();
    }

    @Bean(KiteAuthWebClientConfig.KITE_APP_BEAN_ID)
    public WebClient kiteAppWebClient() {
        return WebClient.builder()
                .baseUrl(kiteProperties.getHost().getAppHost())
                .defaultHeader(KiteConstants.VERSION_KEY, kiteProperties.getVersion())
                .build();
    }
}
