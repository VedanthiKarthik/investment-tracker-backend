package com.vk.pit.kite.commons.web;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import reactor.core.publisher.Mono;

@Service
public abstract class WebFormRequestProvider {

    public abstract <RES> Mono<RES> invokeWebFormRequestMono(String webclientBeanName, String serviceUrl, MultiValueMap<String, String> request, HttpHeaders httpRequestHeaders, Class<RES> responseType);
    public  <RES> Mono<RES> invokeWebFormRequestMono(String webclientBeanName, String serviceUrl, MultiValueMap<String, String> request, Class<RES> responseType){
        return invokeWebFormRequestMono(webclientBeanName, serviceUrl, request, new HttpHeaders(), responseType);
    }
}
