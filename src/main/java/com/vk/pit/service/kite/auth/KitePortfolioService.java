package com.vk.pit.service.kite.auth;

import com.vk.pit.entity.pojo.ResponseDataWrapper;
import com.vk.pit.entity.pojo.user.UserProfileData;
import org.springframework.stereotype.Service;

@Service
public interface KitePortfolioService {
    public ResponseDataWrapper<UserProfileData> getUserProfile();
}
