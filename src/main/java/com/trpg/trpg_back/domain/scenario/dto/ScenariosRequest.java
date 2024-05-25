package com.trpg.trpg_back.domain.scenario.dto;

import com.trpg.trpg_back.domain.scenario.serviceImpl.ScenariosType;
import lombok.Data;

@Data
public class ScenariosRequest {
    Long scenarioSeq;
    Long scenarioId;
    String scenarioTitle;
    String scenarioComment;
    ScenariosType scenarioType;
    String scenarioContents;
    int writerId;
}