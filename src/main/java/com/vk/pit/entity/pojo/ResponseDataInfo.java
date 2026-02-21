package com.vk.pit.entity.pojo;

import lombok.Builder;

@Builder
public class ResponseDataInfo {
    private int statusCode;
    private String message;
    private String statusType;
}
