package com.trpg.trpg_back.domain.scenario.dto;

import lombok.Data;

@Data
public class ScenariosResponse {

    private Long scenario_id;
    private String scenario_title;
    private String scenario_contents;
    private String scenario_type;
    private int writer_id;
    private String use_yn;

    public ScenariosResponse(Long scenarioId, String scenarioTitle, String scenarioContents, Integer writerId) {
        this.scenario_id = scenarioId;
        this.scenario_title = scenarioTitle;
        this.scenario_contents = scenarioContents;
        this.writer_id = writerId;
        // scenario_type과 use_yn 필드는 적절한 값으로 설정하거나, 추가적인 파라미터를 받아 설정해야 합니다.
    }

}
