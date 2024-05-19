package com.trpg.trpg_back.domain.scenario.serviceImpl;

public enum ScenariosType {
    ALL, NEW, POPULAR, RECOMMEND;

    private final String type;

    ScenariosType() {
        this.type = name();
    }
}
