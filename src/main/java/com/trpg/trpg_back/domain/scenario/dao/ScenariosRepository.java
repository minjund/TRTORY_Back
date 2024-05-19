package com.trpg.trpg_back.domain.scenario.dao;

import com.trpg.trpg_back.domain.scenario.dto.ScenariosResponse;
import com.trpg.trpg_back.domain.scenario.entity.Scenarios;
import com.trpg.trpg_back.domain.scenario.serviceImpl.ScenariosType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScenariosRepository extends JpaRepository<Scenarios, Long>, ScenariosCustomRepository {

    List<ScenariosResponse> searchScenario(Long boardId, ScenariosType ScenariosType);

    Optional<Scenarios> findByScenarioId(Long scenariosId);
}
