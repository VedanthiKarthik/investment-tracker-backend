package com.vk.pit.global;

import com.vk.pit.kite.ResponseDataInfo;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDataWrapper<T> extends BaseResponse {
    private T data;


    @Builder
    public ResponseDataWrapper(T data, List<ResponseDataInfo> message) {
        super(message);
        this.data = data;
    }

}
