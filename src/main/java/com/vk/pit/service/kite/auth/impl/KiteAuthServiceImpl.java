package com.vk.pit.service.kite.auth.impl;

import com.vk.pit.configuration.external.KiteConfigs;
import com.vk.pit.constants.AppConstants;
import com.vk.pit.entity.pojo.ResponseDataWrapper;
import com.vk.pit.entity.pojo.kite.KiteSessionRequest;
import com.vk.pit.entity.pojo.kite.KiteSessionResponseData;
import com.vk.pit.exception.custom.BusinessException;
import com.vk.pit.hanlder.KiteServiceHandler;
import com.vk.pit.service.kite.auth.KiteAuthService;
import com.vk.pit.utility.CommonUtility;
import com.vk.pit.utility.KiteServiceUtility;
import com.vk.pit.utility.hash.Hash;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

import static com.vk.pit.constants.ResponseTypes.SUCCESS;

@Service
public class KiteAuthServiceImpl implements KiteAuthService {

    private final KiteServiceHandler kiteServiceHandler;
    private final KiteConfigs kiteConfigs;
    private final Hash hash;

    public KiteAuthServiceImpl(KiteServiceHandler kiteServiceHandler, KiteConfigs kiteConfigs, @Qualifier("sha256Hash") Hash hash) {
        this.kiteServiceHandler = kiteServiceHandler;
        this.kiteConfigs = kiteConfigs;
        this.hash = hash;
    }

    @Override
    public String getKiteLoginUrl() {
        return UriComponentsBuilder
                .fromPath(kiteConfigs.getService().getLoginUrl())
                .host(kiteConfigs.getHost().getAppHost())
                .queryParam(AppConstants.VERSION_KEY, kiteConfigs.getVersion())
                .queryParam(AppConstants.API_KEY, kiteConfigs.getApiKey())
                .build()
                .toUriString();
    }

    @Override
    public ResponseDataWrapper<KiteSessionResponseData> getKiteAuthSessionDetails(String status, String requestToken) {
        if(status.toUpperCase().equals(AppConstants.SUCCESS_UPPERCASE)){
            HttpHeaders requestHeaders = new HttpHeaders();

            String apiKey = "fetch from the evn";
            String kiteSecret = "fetch from env";
            String checksum = hash.hash(apiKey+requestToken+kiteSecret);
            KiteServiceUtility.addKiteSessionHeader(requestHeaders);
            return kiteServiceHandler.getKiteSessionData("https://api.kite.trade/session/token", apiKey, requestToken, checksum, requestHeaders);
        }
        else {
            throw new BusinessException("Error while obtain");
        }
    }

}
