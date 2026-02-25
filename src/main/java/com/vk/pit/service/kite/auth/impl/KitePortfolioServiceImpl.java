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
    public ResponseDataWrapper<UserProfileData> getUserProfile(HttpHeaders headers) {
        KiteServiceUtility.addKiteAPIHeaders(headers);
//        String getProfileUrl = kiteConfigs.getHost().getApiHost()+kiteConfigs.getService().getProfileUrl();
        String getProfileUrl = "https://api.kite.trade/user/profile";
        return kiteServiceHandler.getUserProfile(getProfileUrl, headers);
    }

//    public ResponseDataWrapper<UserProfileData> getUserProfile() {

}
