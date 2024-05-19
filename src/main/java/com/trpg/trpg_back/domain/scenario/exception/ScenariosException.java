package com.trpg.trpg_back.domain.scenario.exception;

public class ScenariosException extends RuntimeException {

    protected ScenariosException() {
        super();
    }

    protected ScenariosException(String msg) {
        super(msg);
    }

    public ScenariosException(String msg, Exception e) {
        super(msg, e);
    }

}
