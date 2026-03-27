package com.vk.pit.kite.auth;

import com.vk.pit.global.exception.custom.BusinessException;
import com.vk.pit.kite.auth.pojo.KiteSessionResponse;
import com.vk.pit.kite.commons.KiteConstants;
import com.vk.pit.kite.commons.KiteProperties;
import com.vk.pit.kite.commons.web.KiteAuthWebClientConfig;
import com.vk.pit.kite.commons.web.WebFormRequestProvider;
import com.vk.pit.utility.hash.Hash;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.random.RandomGenerator;

@Slf4j
@Service
public class KiteAuthServiceImpl implements KiteAuthService {

    private final KiteProperties kiteAuthProperties;
    private final Hash hash;
    private final WebFormRequestProvider webFormRequestProvider;

    public KiteAuthServiceImpl(KiteProperties kiteAuthProperties, Hash hash, WebFormRequestProvider webFormRequestProvider) {
        this.kiteAuthProperties = kiteAuthProperties;
        this.hash = hash;
        this.webFormRequestProvider = webFormRequestProvider;
    }


    private String getKiteLoginUrl() {
        RandomGenerator random = RandomGenerator.getDefault();
        String rp = "session="+random.nextInt(9999, Integer.MAX_VALUE);
        return UriComponentsBuilder
                .newInstance()
                .scheme(KiteConstants.HTTPS)
                .path(kiteAuthProperties.getService().getLoginUrl())
                .host(kiteAuthProperties.getHost().getAppHost())
                .queryParam(KiteConstants.VERSION_KEY, kiteAuthProperties.getVersion())
                .queryParam("redirect_params", rp)
                .queryParam(KiteConstants.API_KEY, kiteAuthProperties.getApiKey())
                .build()
                .toUriString();
    }

    @Override
    public void redirectKiteLogin(HttpServletResponse response) {
        try {
            response.sendRedirect(getKiteLoginUrl());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public KiteSessionResponse getKiteAuthSessionDetails(String status, String requestToken, String session) {
        if(status.toUpperCase().equals(KiteConstants.SUCCESS_UPPERCASE)){
            String checksum = hash.hash(kiteAuthProperties.getApiKey()+requestToken+ kiteAuthProperties.getApiSecret());
            MultiValueMap<String, String> multivalueRequest = new LinkedMultiValueMap<>();
            multivalueRequest.add("request_token", requestToken);
            multivalueRequest.add("checksum", checksum);
            multivalueRequest.add("api_key", kiteAuthProperties.getApiKey());

            return webFormRequestProvider.invokeWebFormRequestMono(
                    KiteAuthWebClientConfig.KITE_API_BEAN_ID,
                    kiteAuthProperties.getService().getSessionUrl(),
                    multivalueRequest,
                    KiteSessionResponse.class).block();
        }
        else {
            throw new BusinessException("Error while obtain");
        }
    }

}
