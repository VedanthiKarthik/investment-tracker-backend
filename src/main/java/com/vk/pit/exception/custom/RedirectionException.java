package com.vk.pit.exception.custom;

import java.io.IOException;

public class RedirectionException extends RuntimeException {
    public RedirectionException(String message){
        super(message);
    }
}
