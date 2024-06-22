package com.trpg.trpg_back.domain.scenario.dto;

import lombok.Data;

@Data
public class ScenariosResponse {

    private Long scenarioId;
    private String scenarioTitle;
    private String scenarioContents;
    private Integer likeCount;
    private String scenarioType;
    private int writerId;
    private String useYn;

    //jpa 생성자
    public ScenariosResponse(Long scenarioId, String scenarioTitle, String scenarioContents, Integer likeCount, Integer writerId) {
        this.scenarioId = scenarioId;
        this.scenarioTitle = scenarioTitle;
        this.scenarioContents = scenarioContents;
        this.likeCount = likeCount;
        this.writerId = writerId;
    }

}
