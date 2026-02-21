package com.vk.pit.exception;

import com.vk.pit.entity.pojo.BaseResponse;
import com.vk.pit.entity.pojo.ResponseDataInfo;
import com.vk.pit.entity.pojo.ResponseDataWrapper;
import com.vk.pit.exception.custom.BusinessException;
import com.vk.pit.exception.custom.RedirectionException;
import com.vk.pit.utility.CommonUtility;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<BaseResponse> handleBusinessExceptions(BusinessException ex){
        List<ResponseDataInfo> responseDataInfoList = new ArrayList<>();
        CommonUtility.addBusinessErrorMessage(ex.getMessage(), responseDataInfoList);
        return ResponseEntity
                .ok(ResponseDataWrapper.builder()
                        .message(responseDataInfoList)
                        .build());
    }

    @ExceptionHandler(RedirectionException.class)
    public ResponseEntity<BaseResponse> handleRedirectionExceptions(RedirectionException ex){
        List<ResponseDataInfo> responseDataInfoList = new ArrayList<>();
        CommonUtility.addServiceUnavailableMessage(ex.getMessage(), responseDataInfoList);
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(ResponseDataWrapper.builder()
                        .message(responseDataInfoList)
                        .build());
    }
}
