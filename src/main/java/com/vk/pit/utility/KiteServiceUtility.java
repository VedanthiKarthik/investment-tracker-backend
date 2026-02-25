package com.vk.pit.utility;

import com.vk.pit.configuration.external.KiteConfigs;
import com.vk.pit.constants.AppConstants;
import org.springframework.http.HttpHeaders;

import java.util.Map;
import java.util.Objects;

public class KiteServiceUtility {
    private final KiteConfigs kiteConfigs;

    public KiteServiceUtility(KiteConfigs kiteConfigs) {
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
        requestHeaders.add(AppConstants.AUTHIRIZATION, "token "+""+":"+ kiteAccessToken);
    }
    public static void addKiteSessionHeader(HttpHeaders requestHeaders){
        requestHeaders.add("X-Kite-Version", "3");
    }
}
