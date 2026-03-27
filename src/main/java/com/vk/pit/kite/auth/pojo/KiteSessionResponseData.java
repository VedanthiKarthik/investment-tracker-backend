package com.vk.pit.kite.auth.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KiteSessionResponseData {
    @JsonProperty(value = "access_token")
    private String accessToken;
    @JsonProperty(value = "api_key")
    private String apiKey;
    @JsonProperty(value = "user_id")
    private String userId;
    @JsonProperty(value = "user_name")
    private String username;
}
