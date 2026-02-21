package com.vk.pit.entity.pojo;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@SuperBuilder
public class BaseResponse {
    private List<ResponseDataInfo> message;
}
