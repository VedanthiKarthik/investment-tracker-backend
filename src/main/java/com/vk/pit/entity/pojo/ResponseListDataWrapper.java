package com.vk.pit.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class ResponseListDataWrapper<T> extends BaseResponse {
    private List<T> data;
}
