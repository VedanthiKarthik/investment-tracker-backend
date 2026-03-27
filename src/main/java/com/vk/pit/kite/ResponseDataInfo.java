package com.vk.pit.kite;

import lombok.Builder;

@Builder
public class ResponseDataInfo {
    private int statusCode;
    private String message;
    private String statusType;
}
