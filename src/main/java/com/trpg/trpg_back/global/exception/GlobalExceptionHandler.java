package com.trpg.trpg_back.global.exception;

import com.trpg.trpg_back.global.comm.responseData.ResponseData;
import com.trpg.trpg_back.global.comm.responseData.ResponseDataCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseData<String>> handleGlobalException(RuntimeException e) {
        ResponseData<String> responseDataDTO = new ResponseData<>();
        responseDataDTO.setCode(ResponseDataCode.ERROR.getCode());
        responseDataDTO.setMessage(e.getMessage());
        return new ResponseEntity<>(responseDataDTO, HttpStatus.BAD_REQUEST);
    }
}