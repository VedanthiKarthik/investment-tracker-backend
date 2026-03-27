package com.vk.pit.kite.auth.pojo;

import org.springframework.web.bind.annotation.RequestParam;

public record KiteSessionRequest(
        String action,
        String type,
        String status,
        @RequestParam("request_token") String requestToken
) {}
