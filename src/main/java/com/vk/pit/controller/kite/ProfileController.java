package com.vk.pit.controller.kite;

import com.vk.pit.entity.pojo.ResponseDataWrapper;
import com.vk.pit.entity.pojo.user.UserProfileData;
import com.vk.pit.service.kite.auth.KitePortfolioService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
