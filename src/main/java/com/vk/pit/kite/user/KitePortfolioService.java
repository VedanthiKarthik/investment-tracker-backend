package com.vk.pit.kite.user;

import com.vk.pit.global.ResponseDataWrapper;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
public interface KitePortfolioService {
    ResponseDataWrapper<UserProfileData> getUserProfile(HttpHeaders headers);
}
