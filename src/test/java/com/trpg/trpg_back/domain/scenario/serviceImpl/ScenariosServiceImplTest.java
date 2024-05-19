package com.trpg.trpg_back.domain.scenario.serviceImpl;

import com.trpg.trpg_back.domain.scenario.dto.ScenariosRequest;
import com.trpg.trpg_back.domain.scenario.dto.ScenariosResponse;
import com.trpg.trpg_back.domain.scenario.exception.NoSearchScenariosException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
class ScenariosServiceImplTest {

    @Autowired
    private ScenariosServiceImpl scenariosServiceImpl;

    @Test
    @DisplayName("게시판 생성 테스트")
    void insertDbBoards() {
        //given
        ScenariosRequest scenariosRequest = new ScenariosRequest();
        scenariosRequest.setScenarioTitle("신나는모험");
        scenariosRequest.setScenarioContents("가나나다다라");
        scenariosRequest.setScenarioType(ScenariosType.NEW);
        scenariosRequest.setWriterId(1);

        //when
        Long saveBoardsId = scenariosServiceImpl.saveScenario(scenariosRequest);

        //then
        assertEquals(0, saveBoardsId);
    }

    @Test
    @DisplayName("게시판 업데이트 실패 - 게시글을 찾을 수 없음")
    void updateDbFailBoards() {
        //given
        ScenariosRequest scenariosRequest = new ScenariosRequest();
        scenariosRequest.setScenarioId(2L);
        scenariosRequest.setScenarioTitle("신나는모험");
        scenariosRequest.setScenarioContents("나나나");
        scenariosRequest.setScenarioType(ScenariosType.NEW);

        //when
        NoSearchScenariosException nosb = assertThrows(NoSearchScenariosException.class, () -> scenariosServiceImpl.updateScenario(scenariosRequest));

        //then
        assertEquals("검색된 게시글이 없습니다.", nosb.getMessage());
    }

    @Test
    @DisplayName("게시판 업데이트 성공")
    @Transactional
    void updateDbBoards() {
        //given
        ScenariosRequest scenariosRequest = new ScenariosRequest();
        scenariosRequest.setScenarioTitle("신나는모험");
        scenariosRequest.setScenarioContents("나나나");
        scenariosRequest.setScenarioType(ScenariosType.NEW);

        //when
        //저장 후 업데이트
        Long scenario = scenariosServiceImpl.saveScenario(scenariosRequest);
        scenariosRequest.setScenarioId(scenario);
        Long updateBoardId = scenariosServiceImpl.updateScenario(scenariosRequest);

        //then
        assertEquals(scenariosRequest.getScenarioId(), updateBoardId);
    }

    @Test
    @DisplayName("게시판 조회 성공")
    void searchBoards() {
        //given
        ScenariosRequest scenariosRequest = new ScenariosRequest();
        scenariosRequest.setScenarioTitle("신나는모험");
        scenariosRequest.setScenarioContents("나나나");
        scenariosRequest.setScenarioType(ScenariosType.NEW);

        //when
        //게시판 조회
        Long scenarioId = scenariosServiceImpl.saveScenario(scenariosRequest);
        List<ScenariosResponse> scenarioRespons = scenariosServiceImpl.searchScenario(scenarioId);

        //then
        assertFalse(scenarioRespons.isEmpty());

    }
}