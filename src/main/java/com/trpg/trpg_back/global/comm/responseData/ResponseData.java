package com.trpg.trpg_back.global.comm.responseData;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseData<T> {
        private int code;
        private String message;
        private T item;
}
