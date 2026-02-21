package com.vk.pit.hanlder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.function.Consumer;


/*
    Should be refactored properly
    for generic request and response handling
    Supporting all client calls
*/

@Slf4j
@Service
public class ServiceCallHandler {

    private final WebClient webClient;

    public ServiceCallHandler(WebClient webClient) {
        this.webClient = webClient;
    }

    public <RES> RES invokeGetRequest(String serviceUrl, HttpHeaders httpRequestHeaders, ParameterizedTypeReference<RES> responseType){
        return webClient.get()
                .uri(serviceUrl)
                .headers(httpHeaders-> httpHeaders.addAll(httpRequestHeaders))
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        response -> response.bodyToMono(String.class)
                                .map(body -> new RuntimeException("Client error: " + body)))
                .onStatus(HttpStatusCode::is5xxServerError,
                        response -> response.bodyToMono(String.class)
                                .map(body -> new RuntimeException("Server error: " + body)))
                .bodyToMono(responseType)
                .doOnNext(res -> log.info("POST Response: {}", res))
                .block();
    }

    public <REQ, RES> RES invokePostRequest(String serviceUrl, REQ request, HttpHeaders httpRequestHeaders, ParameterizedTypeReference<RES> responseType){
        return webClient.post()
                .uri(serviceUrl)
                .bodyValue(request)
                .headers(httpHeaders-> httpHeaders.addAll(httpRequestHeaders))
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        response -> response.bodyToMono(String.class)
                                .map(body -> new RuntimeException("Client error: " + body)))
                .onStatus(HttpStatusCode::is5xxServerError,
                        response -> response.bodyToMono(String.class)
                                .map(body -> new RuntimeException("Server error: " + body)))
                .bodyToMono(responseType)
                .doOnNext(res -> log.info("POST Response: {}", res))
                .block();
    }

    public <RES> RES invokeMultipartRequest(String serviceUrl, MultipartBodyBuilder request, HttpHeaders httpRequestHeaders, ParameterizedTypeReference<RES> responseType){
        return webClient.post()
                .uri(serviceUrl)
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData(request.build()))
                .headers(httpHeaders-> httpHeaders.addAll(httpRequestHeaders))
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        response -> response.bodyToMono(String.class)
                                .map(body -> new RuntimeException("Client error: " + body)))
                .onStatus(HttpStatusCode::is5xxServerError,
                        response -> response.bodyToMono(String.class)
                                .map(body -> new RuntimeException("Server error: " + body)))
                .bodyToMono(responseType)
                .doOnNext(res -> log.info("POST Response: {}", res))
                .block();
    }

    public <RES> RES invokeFormRequest(String serviceUrl, MultiValueMap<String, String> request, HttpHeaders httpRequestHeaders, ParameterizedTypeReference<RES> responseType){
        log.info("Request :"+request.toString());
        return webClient.post()
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
                .bodyToMono(responseType)
                .doOnNext(res -> log.info("POST Response: {}", res))
                .block();
    }




}
