package com.trpg.trpg_back.domain.scenario.entity;

import com.trpg.trpg_back.domain.scenario.dto.ScenariosRequest;
import com.trpg.trpg_back.domain.scenario.serviceImpl.ScenariosType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScenariosTest {
    @Test
    @DisplayName("게시판 생성")
    public void testCreateBoard() {
        //given
        Scenarios scenarios = new Scenarios();

        ScenariosRequest scenariosRequest = new ScenariosRequest();
        scenariosRequest.setScenarioTitle("신나는모험");
        scenariosRequest.setScenarioContents("가나나다다라");
        scenariosRequest.setScenarioType(ScenariosType.NEW);
        scenariosRequest.setWriterId(1);

        //when
        scenarios.createScenario(scenariosRequest);

        //then
        assertEquals(scenariosRequest.getScenarioTitle(), scenarios.getScenarioTitle());
        assertEquals(scenariosRequest.getScenarioContents(), scenarios.getScenarioContents());
        assertEquals(scenariosRequest.getScenarioType().name(), scenarios.getScenarioType());
        assertEquals(scenariosRequest.getWriterId(), scenarios.getWriterId());
        assertEquals("Y", scenarios.getUseYn());
    }

    @Test
    @DisplayName("게시판 종류 리스트 조회")
    void boardsTypeList() {
        //given
        Scenarios scenarios = new Scenarios();

        //when
        ScenariosType[] scenariosTypes = scenarios.scenarioTypeList();

        //then
        assertEquals(4, scenariosTypes.length);
    }
}