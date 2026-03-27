package com.vk.pit.kite.user;

import com.vk.pit.global.ResponseDataWrapper;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
public class KitePortfolioServiceImpl implements KitePortfolioService {


    @Override
    public ResponseDataWrapper<UserProfileData> getUserProfile(HttpHeaders headers) {
//        KiteServiceUtility.addKiteAPIHeaders(headers);
////        String getProfileUrl = kiteConfigs.getHost().getApiHost()+kiteConfigs.getService().getProfileUrl();
//        String getProfileUrl = "https://api.kite.trade/user/profile";
//        return kiteAuthServiceHandler.getUserProfile(getProfileUrl, headers);
        return null;
    }

//    public ResponseDataWrapper<UserProfileData> getUserProfile() {

}
