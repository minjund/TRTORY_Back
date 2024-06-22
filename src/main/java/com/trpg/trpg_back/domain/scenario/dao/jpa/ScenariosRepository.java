package com.trpg.trpg_back.domain.scenario.dao.jpa;

import com.trpg.trpg_back.domain.scenario.dto.ScenariosResponse;
import com.trpg.trpg_back.domain.scenario.entity.Scenarios;
import com.trpg.trpg_back.domain.scenario.serviceImpl.ScenariosType;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScenariosRepository extends JpaRepository<Scenarios, Long>, ScenariosCustomRepository {

    List<ScenariosResponse> searchScenario(Long boardId, ScenariosType ScenariosType);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Scenarios> findByScenarioId(Long scenariosId);
}
