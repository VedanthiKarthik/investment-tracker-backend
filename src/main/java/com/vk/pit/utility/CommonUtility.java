package com.vk.pit.utility;

import com.vk.pit.constants.ResponseTypes;
import com.vk.pit.entity.pojo.ResponseDataInfo;



import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;

public class CommonUtility {
    private static ResponseDataInfo populateResponseErrorMessage(String message, ResponseTypes errorType) {
        return ResponseDataInfo.builder()
                .statusCode(errorType.getResponseTypeCode())
                .statusType(errorType.getResponseTypeName())
                .message(message)
                .build();
    }

    public static void addBusinessErrorMessage(String message, List<ResponseDataInfo> responseDataInfoList) {
        responseDataInfoList.add(populateResponseErrorMessage(message, ResponseTypes.BUSINESS_ERROR));
    }

    public static void addServiceUnavailableMessage(String message, List<ResponseDataInfo> responseDataInfoList) {
        responseDataInfoList.add(populateResponseErrorMessage(message, ResponseTypes.BUSINESS_ERROR));
    }

    public static void addSuccessMessage(String message, List<ResponseDataInfo> responseDataInfoList) {
        responseDataInfoList.add(populateResponseErrorMessage(message, ResponseTypes.SUCCESS));
    }

    public static void addRequestError(String message, List<ResponseDataInfo> responseDataInfoList) {
        responseDataInfoList.add(populateResponseErrorMessage(message, ResponseTypes.REQUEST_ERROR));
    }


}
