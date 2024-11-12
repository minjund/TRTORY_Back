package com.trpg.trpg_back.domain.scenario.serviceImpl;


import com.trpg.trpg_back.domain.scenario.dao.jpa.ScenariosRepository;
import com.trpg.trpg_back.domain.scenario.dto.ScenariosRequest;
import com.trpg.trpg_back.domain.scenario.dto.ScenariosResponse;
import com.trpg.trpg_back.domain.scenario.entity.Scenarios;
import com.trpg.trpg_back.domain.scenario.exception.NoSearchScenariosException;
import jakarta.persistence.LockModeType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScenariosServiceImpl {
    private final ScenariosRepository scenariosRepository;

    @Transactional
    public Long saveScenario(ScenariosRequest scenariosRequest) {
        Scenarios scenarios = Scenarios.createScenario(scenariosRequest);

        scenariosRepository.save(scenarios);

        return scenarios.getScenarioId();
    }

    @Transactional
    public Long updateScenario(ScenariosRequest scenariosRequest) {
        Scenarios scenarios = scenariosRepository.findByScenarioId(scenariosRequest.scenarioId())
                .orElseThrow(NoSearchScenariosException::new);

        scenarios.updateScenario(scenariosRequest);

        return scenarios.getScenarioId();
    }

    @Transactional
    public List<ScenariosResponse> searchScenario(Long boardId) {
        return scenariosRepository.searchScenario(boardId, ScenariosType.NEW);

    }

    @Transactional
    public Long updateLikeScenario(ScenariosRequest scenariosRequest) {

        Scenarios scenarios = scenariosRepository.findByScenarioId(scenariosRequest.scenarioId())
                .orElseThrow(NoSearchScenariosException::new);

        scenarios.increasedLikeCount();

        return scenarios.getScenarioId();
    }
}
