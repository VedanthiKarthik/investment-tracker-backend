package com.vk.pit.global;

import com.vk.pit.kite.ResponseDataInfo;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ResponseDataWrapper<T> extends BaseResponse {
    private T data;
}
