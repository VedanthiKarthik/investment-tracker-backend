package com.vk.pit.utility;


import com.vk.pit.kite.commons.KiteConstants;
import com.vk.pit.kite.commons.KiteProperties;
import org.springframework.http.HttpHeaders;

import java.util.Objects;

public class KiteServiceUtility {
    private final KiteProperties kiteConfigs;

    public KiteServiceUtility(KiteProperties kiteConfigs) {
        this.kiteConfigs = kiteConfigs;
    }

    public static void addKiteAPIHeaders(HttpHeaders requestHeaders){
        addKiteAuthHeader(requestHeaders);
    }

    private static void addKiteAuthHeader(HttpHeaders requestHeaders){
        // fetch from the env
        String kiteAccessToken = Objects.requireNonNull(requestHeaders.get("kite_access_token")).getFirst();
        requestHeaders.clear();
        addKiteSessionHeader(requestHeaders);
        requestHeaders.add(KiteConstants.AUTHORIZATION, "token "+""+":"+ kiteAccessToken);
//        requestHeaders.add(AppConstants.AUTHIRIZATION, "token "+kiteConfigs.getService()+":"+ kiteAccessToken);
    }
    public static void addKiteSessionHeader(HttpHeaders requestHeaders){
        requestHeaders.add("X-Kite-Version", "3");
    }
}
