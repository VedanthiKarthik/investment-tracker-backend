package com.vk.pit.kite.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserProfileData {
    @JsonProperty(value = "user_name")
    private String userName;
    private String email;
}
