package com.vk.pit.utility;

import com.vk.pit.constants.AppConstants;
import org.springframework.http.HttpHeaders;

import java.util.Map;

public class KiteServiceUtility {
    public static void addKiteAPIHeaders(HttpHeaders requestHeaders){
        addKiteAuthHeader(requestHeaders);
    }

    private static void addKiteAuthHeader(HttpHeaders requestHeaders){
        // fetch from the env
        requestHeaders.add(AppConstants.AUTHIRIZATION, "token api_key:access-token");
    }
    public static void addKiteSessionHeader(HttpHeaders requestHeaders){
        requestHeaders.add("X-Kite-Version", "3");
    }
}
