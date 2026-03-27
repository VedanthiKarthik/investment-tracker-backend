package com.vk.pit.global;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseTypes {

    BUSINESS_ERROR("Success", 200, ""),
    INTERNAL_SERVER_ERROR("Service Unavailable", 500,"Unable to Process your Request Right now. Please try again later."),
    REQUEST_ERROR("Invalid Request", 400,""),
    SUCCESS("Success", 200,"Request Successfully Processed");

    private final String responseTypeName;
    private final int responseTypeCode;
    private final String commonMessage;
}
