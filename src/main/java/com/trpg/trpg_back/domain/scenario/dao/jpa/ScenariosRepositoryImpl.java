package com.trpg.trpg_back.domain.scenario.dao.jpa;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.trpg.trpg_back.domain.scenario.dto.ScenariosResponse;
import com.trpg.trpg_back.domain.scenario.serviceImpl.ScenariosType;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.trpg.trpg_back.domain.scenario.entity.QScenarios.scenarios;
import static org.springframework.util.ObjectUtils.isEmpty;

@RequiredArgsConstructor
public class ScenariosRepositoryImpl implements ScenariosCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<ScenariosResponse> searchScenario(Long boardId, ScenariosType ScenariosType) {

        return queryFactory.
                select(Projections.constructor(ScenariosResponse.class,
                        scenarios.scenarioId,
                        scenarios.scenarioTitle,
                        scenarios.scenarioContents,
                        scenarios.likeCount,
                        scenarios.writerId))
                .from(scenarios)
                .where(boardsTypeEq(ScenariosType.name()),
                        boardIdEq(boardId))
                .fetch();
    }

    private BooleanExpression boardIdEq(Long BoardId) {
        return isEmpty(BoardId) ? null : scenarios.scenarioId.eq(BoardId);
    }

    private BooleanExpression boardsTypeEq(String BoardsTypeName) {
        return isEmpty(BoardsTypeName) ? null : scenarios.scenarioType.eq(BoardsTypeName);
    }
}
