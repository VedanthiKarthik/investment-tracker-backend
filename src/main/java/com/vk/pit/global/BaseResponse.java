package com.vk.pit.global;

import com.vk.pit.kite.ResponseDataInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@SuperBuilder
public class BaseResponse {
    private List<ResponseDataInfo> message;
}
