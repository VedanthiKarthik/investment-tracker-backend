package com.vk.pit.kite.commons.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class WebFormRequestImpl extends WebFormRequestProvider{

    private final WebClientProviderFactory webClientProviderFactory;

    public WebFormRequestImpl(WebClientProviderFactory webClientProviderFactory) {
        this.webClientProviderFactory = webClientProviderFactory;
    }


    @Override
    public <RES> Mono<RES> invokeWebFormRequestMono(String webclientBeanName, String serviceUrl, MultiValueMap<String, String> request, HttpHeaders httpRequestHeaders, Class<RES> responseType) {
        return webClientProviderFactory.getWebClient(webclientBeanName).post()
                .uri(serviceUrl)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(request))
                .headers(httpHeaders-> httpHeaders.addAll(httpRequestHeaders))
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        response -> response.bodyToMono(String.class)
                                .map(body -> new RuntimeException("Client error: " + body)))
                .onStatus(HttpStatusCode::is5xxServerError,
                        response -> response.bodyToMono(String.class)
                                .map(body -> new RuntimeException("Server error: " + body)))
                .bodyToMono(responseType);
    }
}
