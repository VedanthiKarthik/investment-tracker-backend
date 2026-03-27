package com.vk.pit.kite.commons.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class WebClientProviderFactory {
    private final Map<String, WebClient> webClient;

    public WebClient getWebClient(String webClientType) {
        return webClient.get(webClientType);
    }
}
