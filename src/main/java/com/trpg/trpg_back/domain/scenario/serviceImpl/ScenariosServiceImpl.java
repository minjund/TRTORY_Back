package com.trpg.trpg_back.domain.scenario.serviceImpl;


import com.trpg.trpg_back.domain.scenario.dao.ScenariosRepository;
import com.trpg.trpg_back.domain.scenario.dto.ScenariosRequest;
import com.trpg.trpg_back.domain.scenario.dto.ScenariosResponse;
import com.trpg.trpg_back.domain.scenario.entity.Scenarios;
import com.trpg.trpg_back.domain.scenario.exception.NoSearchScenariosException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScenariosServiceImpl {
    private static Scenarios scenarios = new Scenarios();

    private final ScenariosRepository scenariosRepository;

    @Transactional
    public Long saveScenario(ScenariosRequest scenariosRequest) {
        scenarios.createScenario(scenariosRequest);

        scenarios = scenariosRepository.save(scenarios);

        return scenarios.getScenarioId();
    }

    @Transactional
    public Long updateScenario(ScenariosRequest scenariosRequest) {
        Scenarios scenarios = scenariosRepository.findByScenarioId(scenariosRequest.getScenarioId())
                .orElseThrow(NoSearchScenariosException::new);

        scenarios.updateScenario(
                scenariosRequest.getScenarioId(),
                scenariosRequest.getScenarioTitle(),
                scenariosRequest.getScenarioContents(),
                scenariosRequest.getScenarioType(),
                scenariosRequest.getWriterId()
        );

        return scenarios.getScenarioId();
    }

    public List<ScenariosResponse> searchScenario(Long boardId) {

        return scenariosRepository.searchScenario(boardId, ScenariosType.NEW);

    }

    public ScenariosType[] ScenarioTypeList() {
        return scenarios.scenarioTypeList();
    }
}
