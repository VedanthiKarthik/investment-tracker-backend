package com.vk.pit.entity.pojo.kite;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;

public record KiteSessionRequest(
        String action,
        String type,
        String status,
        @RequestParam("request_token") String requestToken
) {}
