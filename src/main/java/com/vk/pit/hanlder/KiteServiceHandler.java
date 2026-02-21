package com.vk.pit.hanlder;

import com.vk.pit.entity.pojo.ResponseDataWrapper;
import com.vk.pit.entity.pojo.kite.KiteSessionResponseData;
import com.vk.pit.entity.pojo.user.UserProfileData;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.awt.datatransfer.Clipboard;
import java.util.HashMap;
import java.util.Map;

@Service
public class KiteServiceHandler {
    private final ServiceCallHandler serviceCallHandler;

    public KiteServiceHandler(ServiceCallHandler serviceCallHandler) {
        this.serviceCallHandler = serviceCallHandler;
    }

    public ResponseDataWrapper<UserProfileData> getUserProfile(String getProfileUrl, HttpHeaders requestHeaders){
        return serviceCallHandler.invokeGetRequest(getProfileUrl, requestHeaders, new ParameterizedTypeReference<>() {
        });
    }

    public ResponseDataWrapper<KiteSessionResponseData> getKiteSessionData(String sessionUrl, String apiKey, String requestToken, String checksum, HttpHeaders requestHeaders) {
        MultiValueMap<String, String> multivalueRequest = new LinkedMultiValueMap<>();
        multivalueRequest.add("request_token", requestToken);
        multivalueRequest.add("checksum", checksum);
        multivalueRequest.add("api_key", apiKey);

        return serviceCallHandler.invokeFormRequest(sessionUrl, multivalueRequest, requestHeaders,  new ParameterizedTypeReference<>() {
        });
    }

//    public ResponseDataWrapper<KiteSessionResponseData> getKiteSessionData(String kiteSessionUrl){
//
//    }
}
