package com.vk.pit.service.kite.auth;

import com.vk.pit.entity.pojo.ResponseDataWrapper;
import com.vk.pit.entity.pojo.kite.KiteSessionRequest;
import com.vk.pit.entity.pojo.kite.KiteSessionResponseData;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface KiteAuthService {
    public String getKiteLoginUrl();
    ResponseDataWrapper<KiteSessionResponseData> getKiteAuthSessionDetails(String status, String requestToken);
//    Map<String, Object> getKiteAuthSessionDetails(String status, String requestToken);
}
