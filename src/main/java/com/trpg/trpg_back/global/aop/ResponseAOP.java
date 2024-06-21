package com.trpg.trpg_back.global.aop;

import com.trpg.trpg_back.global.comm.responseData.ResponseData;
import com.trpg.trpg_back.global.comm.responseData.ResponseDataCode;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ResponseAOP {
    @Around("execution(* com.trpg.trpg_back.domain..api.*.*(..))")
    public ResponseEntity<?> setResponseData(ProceedingJoinPoint joinPoint) throws Throwable {
        ResponseData<Object> responseData = new ResponseData<>();
        Object result = joinPoint.proceed();

        responseData.setCode(ResponseDataCode.SUCCESS.getCode());
        responseData.setMessage("요청 성공");

        if (result instanceof ResponseEntity) {
            responseData.setItem(((ResponseEntity<?>) result).getBody());
            return new ResponseEntity<>(responseData, ((ResponseEntity<?>) result).getStatusCode());
        } else {
            responseData.setItem(result);
            return new ResponseEntity<>(responseData, HttpStatus.OK);
        }
    }

}
