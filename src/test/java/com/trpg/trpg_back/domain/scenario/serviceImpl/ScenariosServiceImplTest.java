package com.trpg.trpg_back.domain.scenario.serviceImpl;

import com.trpg.trpg_back.domain.scenario.dao.jpa.ScenariosRepository;
import com.trpg.trpg_back.domain.scenario.dto.ScenariosRequest;
import com.trpg.trpg_back.domain.scenario.dto.ScenariosResponse;
import com.trpg.trpg_back.domain.scenario.entity.Scenarios;
import com.trpg.trpg_back.domain.scenario.exception.NoSearchScenariosException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
@Slf4j
class ScenariosServiceImplTest {

    @Autowired
    private ScenariosServiceImpl scenariosServiceImpl;

    @Autowired
    private ScenariosRepository scenariosRepository;

    Integer likeCount = null;
    @BeforeEach
    void setUp() {
        List<ScenariosResponse> scenariosResponses = scenariosServiceImpl.searchScenario(9L);
        likeCount = scenariosResponses.get(0).getLikeCount();
    }

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
        scenariosRequest.setScenarioId(9999999L);
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
    void updateDbBoards() {
        //given
        ScenariosRequest scenariosRequest = new ScenariosRequest();
        scenariosRequest.setScenarioId(9L);
        scenariosRequest.setScenarioTitle("신나는모험");
        scenariosRequest.setScenarioContents("나나나");
        scenariosRequest.setScenarioType(ScenariosType.NEW);

        //when
        //저장 후 업데이트
        Long updateBoardId = scenariosServiceImpl.updateScenario(scenariosRequest);

        Scenarios scenarios = scenariosRepository.findByScenarioId(scenariosRequest.getScenarioId())
                .orElseThrow(NoSearchScenariosException::new);

        //then
        assertEquals(scenariosRequest.getScenarioId(), updateBoardId);
        assertEquals(scenariosRequest.getScenarioTitle(), scenarios.getScenarioTitle());
        assertEquals(scenariosRequest.getScenarioContents(), scenarios.getScenarioContents());
    }

    @Test
    @DisplayName("게시판 조회 성공")
    void searchBoards() {
        //given
        ScenariosRequest scenariosRequest = new ScenariosRequest();
        scenariosRequest.setScenarioId(9L);
        scenariosRequest.setScenarioTitle("신나는모험");
        scenariosRequest.setScenarioContents("나나나");
        scenariosRequest.setScenarioType(ScenariosType.NEW);

        //when
        //게시판 조회
        List<ScenariosResponse> scenarioRespons = scenariosServiceImpl.searchScenario(scenariosRequest.getScenarioId());

        //then
        assertFalse(scenarioRespons.isEmpty());
    }

    @Test
    @DisplayName("좋아요 동시 클릭")
    void updateLikeBoards() throws InterruptedException {
        //given
        ScenariosRequest scenariosRequest = new ScenariosRequest();
        scenariosRequest.setScenarioId(9L);
        scenariosRequest.setScenarioType(ScenariosType.NEW);

        // thread 사용할 수 있는 서비스 선언, 몇 개의 스레드 사용할건지 지정
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // countDown()을 통해 0까지 세어야 await()하던 thread가 다시 실행됨
        CountDownLatch latch = new CountDownLatch(2);

        //when
        // thread 실행
        // 보통 for문안에서 여러번 같은 코드를 실행시킴
        executorService.execute(() -> {
            // thread가 실행할 작업 코드 ...
            scenariosServiceImpl.updateLikeScenario(scenariosRequest);
            // CountDownLatch의 카운트 감소
            latch.countDown();
        });

        executorService.execute(() -> {
            // thread가 실행할 작업 코드 ...
            scenariosServiceImpl.updateLikeScenario(scenariosRequest);

            latch.countDown();
        });

        latch.await();

        Optional<Scenarios> byScenarioId = scenariosRepository.findByScenarioId(scenariosRequest.getScenarioId());
        //then
        assertEquals(likeCount+2, byScenarioId.get().getLikeCount());

    }
}