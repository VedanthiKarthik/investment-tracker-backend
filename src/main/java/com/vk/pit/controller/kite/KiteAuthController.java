package com.vk.pit.controller.kite;

import com.vk.pit.entity.pojo.BaseResponse;
import com.vk.pit.entity.pojo.ResponseDataWrapper;
import com.vk.pit.entity.pojo.kite.KiteSessionRequest;
import com.vk.pit.entity.pojo.kite.KiteSessionResponseData;
import com.vk.pit.exception.custom.RedirectionException;
import com.vk.pit.service.kite.auth.KiteAuthService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1/user")
public class KiteAuthController {

    private final KiteAuthService kiteAuthService;

    public KiteAuthController(KiteAuthService kiteAuthService) {
        this.kiteAuthService = kiteAuthService;
    }


    @GetMapping(path = "/login")
    public void kiteLogin(HttpServletResponse response) {
        try {
            response.sendRedirect(kiteAuthService.getKiteLoginUrl());
        } catch (IOException e) {
            throw new RedirectionException(e.getMessage());
        }
    }

    @GetMapping(path = "/callback")
    public ResponseEntity<ResponseDataWrapper<KiteSessionResponseData>> authCallback(@RequestParam String action,
                                                                                     @RequestParam String type,
                                                                                     @RequestParam String status,
                                                                                     @RequestParam("request_token") String requestToken) {
        return ResponseEntity.ok(kiteAuthService.getKiteAuthSessionDetails(status,requestToken));
    }
}
