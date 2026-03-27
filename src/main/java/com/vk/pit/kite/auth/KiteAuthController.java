package com.vk.pit.kite.auth;

import com.vk.pit.kite.auth.pojo.KiteSessionResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/user")
class KiteAuthController {

    private final KiteAuthService kiteAuthService;

    public KiteAuthController(KiteAuthService kiteAuthService) {
        this.kiteAuthService = kiteAuthService;
    }


    @GetMapping(path = "/login")
    void kiteLogin(HttpServletResponse response) {
            kiteAuthService.redirectKiteLogin(response);
    }

    @GetMapping(path = "/callback")
    KiteSessionResponse authCallback(@RequestParam String action,
                                           @RequestParam String type,
                                           @RequestParam String status,
                                           @RequestParam String session,
                                           @RequestParam("request_token") String requestToken) {
        return kiteAuthService.getKiteAuthSessionDetails(status,requestToken, session);
    }
}
