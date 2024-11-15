package com.trpg.trpg_back.domain.scenario.entity;


import com.trpg.trpg_back.domain.scenario.dto.ScenariosRequest;
import com.trpg.trpg_back.domain.scenario.serviceImpl.ScenariosType;
import com.trpg.trpg_back.global.util.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "scenario")
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    // 참여 인원 수
    @Column(name = "parti_user_count", columnDefinition = "int", nullable = true)
    private Integer partiUserCount;

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

    public static Scenarios createScenario(ScenariosRequest scenariosRequest) {
        Scenarios scenarios = new Scenarios();

        scenarios.scenarioId = scenariosRequest.scenarioId();
        scenarios.scenarioTitle = scenariosRequest.scenarioTitle();
        scenarios.scenarioContents = scenariosRequest.scenarioContents();
        scenarios.scenarioType = scenariosRequest.scenarioType().name();
        scenarios.writerId = scenariosRequest.writerId();

        return scenarios;
    }


    public void updateScenario(ScenariosRequest scenariosRequest) {
        this.scenarioSeq = scenariosRequest.scenarioId();
        this.scenarioId = scenariosRequest.scenarioId();
        this.scenarioTitle = scenariosRequest.scenarioTitle();
        this.scenarioContents = scenariosRequest.scenarioContents();
        this.scenarioType = scenariosRequest.scenarioType().name();
        this.writerId = scenariosRequest.writerId();
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
