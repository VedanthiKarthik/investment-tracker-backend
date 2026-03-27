package com.vk.pit.kite.user;

import com.vk.pit.global.ResponseDataWrapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final KitePortfolioService kiteService;

    public ProfileController(KitePortfolioService kiteService) {
        this.kiteService = kiteService;
    }

    @GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDataWrapper<UserProfileData>> getUserProfile(@RequestHeader HttpHeaders headers){
        return ResponseEntity.ok(kiteService.getUserProfile(headers));
    }
}
