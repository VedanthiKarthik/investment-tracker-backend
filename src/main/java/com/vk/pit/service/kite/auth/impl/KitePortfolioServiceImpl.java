package com.vk.pit.service.kite.auth.impl;

import com.vk.pit.configuration.external.KiteConfigs;
import com.vk.pit.entity.pojo.ResponseDataWrapper;
import com.vk.pit.entity.pojo.user.UserProfileData;
import com.vk.pit.hanlder.KiteServiceHandler;
import com.vk.pit.service.kite.auth.KitePortfolioService;
import com.vk.pit.utility.KiteServiceUtility;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
public class KitePortfolioServiceImpl implements KitePortfolioService {

    private final KiteServiceHandler kiteServiceHandler;
    private final KiteConfigs kiteConfigs;

    public KitePortfolioServiceImpl(KiteServiceHandler kiteServiceHandler, KiteConfigs kiteConfigs) {
        this.kiteServiceHandler = kiteServiceHandler;
        this.kiteConfigs = kiteConfigs;
    }

    @Override
    public ResponseDataWrapper<UserProfileData> getUserProfile() {
        HttpHeaders requestHeaders = new HttpHeaders();
        KiteServiceUtility.addKiteAPIHeaders(requestHeaders);
//        String getProfileUrl = kiteConfigs.getHost().getApiHost()+kiteConfigs.getService().getProfileUrl();
        String getProfileUrl = "https://api.kite.trade/user/profile";
        return kiteServiceHandler.getUserProfile(getProfileUrl, requestHeaders);
    }

//    public ResponseDataWrapper<UserProfileData> getUserProfile() {

}
