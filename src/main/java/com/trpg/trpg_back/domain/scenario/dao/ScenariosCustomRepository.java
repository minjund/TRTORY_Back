package com.trpg.trpg_back.domain.scenario.dao;


import com.trpg.trpg_back.domain.scenario.dto.ScenariosResponse;
import com.trpg.trpg_back.domain.scenario.serviceImpl.ScenariosType;

import java.util.List;

public interface ScenariosCustomRepository {

    List<ScenariosResponse> searchScenario(Long boardId, ScenariosType ScenariosType);
}
