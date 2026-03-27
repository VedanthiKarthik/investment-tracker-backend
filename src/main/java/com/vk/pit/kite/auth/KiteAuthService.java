package com.vk.pit.kite.auth;

import com.vk.pit.kite.auth.pojo.KiteSessionResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

@Service
public interface KiteAuthService {
    void redirectKiteLogin(HttpServletResponse response);
    KiteSessionResponse getKiteAuthSessionDetails(String status, String requestToken, String session);
    }
