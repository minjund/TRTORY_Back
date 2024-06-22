package com.trpg.trpg_back.domain.scenario.entity;


import com.trpg.trpg_back.domain.scenario.dto.ScenariosRequest;
import com.trpg.trpg_back.domain.scenario.serviceImpl.ScenariosType;
import com.trpg.trpg_back.global.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "scenario")
public class Scenarios extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scenario_seq", columnDefinition = "bigint", nullable = false)
    private long scenarioSeq;

    @Column(name = "scenario_id", columnDefinition = "bigint", nullable = false)
    private long scenarioId;

    @Column(name = "scenario_title", columnDefinition = "varchar(45)", nullable = false)
    private String scenarioTitle;

    @Column(name = "scenario_introduction", columnDefinition = "varchar(45)", nullable = true)
    private String scenarioIntroduction;

    @Column(name = "scenario_contents", columnDefinition = "varchar(500)", nullable = false)
    private String scenarioContents;

    @Column(name = "scenario_type", columnDefinition = "varchar(45)", nullable = false)
    private String scenarioType;

    @Column(name = "user_count", columnDefinition = "int", nullable = true)
    private Integer userCount;

    @Column(name = "play_difficulty", columnDefinition = "float", nullable = true)
    private float playDifficulty;

    @Column(name = "kippering_difficulty", columnDefinition = "float", nullable = true)
    private float kipperingDifficulty;

    @Column(name = "like_count", columnDefinition = "bigint", nullable = true)
    private int likeCount;

    @Column(name = "expect_play_time", columnDefinition = "datetime", nullable = true)
    private LocalDateTime expectPlayTime;

    @Column(name = "writer_id", columnDefinition = "int", nullable = false)
    private int writerId;

    @Column(name = "writer_caution", columnDefinition = "varchar(45)", nullable = true)
    private String writerCaution;

    @Column(name = "use_yn", columnDefinition = "varchar(2)", nullable = false)
    private String useYn;

    public void createScenario(ScenariosRequest scenariosRequest) {

        this.scenarioId = this.scenarioSeq;
        this.scenarioTitle = scenariosRequest.getScenarioTitle();
        this.scenarioContents = scenariosRequest.getScenarioContents();
        this.scenarioType = scenariosRequest.getScenarioType().name();
        this.writerId = scenariosRequest.getWriterId();
        this.useYn = "Y";
    }


    public void updateScenario(ScenariosRequest scenariosRequest) {
        this.scenarioId = scenariosRequest.getScenarioId();
        this.scenarioTitle = scenariosRequest.getScenarioTitle();
        this.likeCount = 0;
        this.scenarioContents = scenariosRequest.getScenarioContents();
        this.scenarioType = scenariosRequest.getScenarioType().name();
        this.writerId = scenariosRequest.getWriterId();
    }

    // == 비즈니스 로직 == //

    //게시판 종류 리스트 조회
    public ScenariosType[] scenarioTypeList() {
        return ScenariosType.values();
    }

    //좋아요 증가
    public void increasedLikeCount() {
        this.likeCount++;
    }

}
