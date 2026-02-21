package com.vk.pit.entity.pojo.kite;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KiteSessionResponseData {
    @JsonProperty(value = "access_token")
    private String accessToken;
    @JsonProperty(value = "api_key")
    private String apiKey;
}
