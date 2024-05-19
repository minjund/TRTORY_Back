package com.trpg.trpg_back.domain.scenario.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QScenarios is a Querydsl query type for Scenarios
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QScenarios extends EntityPathBase<Scenarios> {

    private static final long serialVersionUID = 83238133L;

    public static final QScenarios scenarios = new QScenarios("scenarios");

    public final com.trpg.trpg_back.global.util.QBaseEntity _super = new com.trpg.trpg_back.global.util.QBaseEntity(this);

    public final DateTimePath<java.time.LocalDateTime> expectPlayTime = createDateTime("expectPlayTime", java.time.LocalDateTime.class);

    public final NumberPath<Float> kipperingDifficulty = createNumber("kipperingDifficulty", Float.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> mod_date = _super.mod_date;

    public final NumberPath<Float> playDifficulty = createNumber("playDifficulty", Float.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> reg_date = _super.reg_date;

    public final StringPath scenarioContents = createString("scenarioContents");

    public final NumberPath<Long> scenarioId = createNumber("scenarioId", Long.class);

    public final StringPath scenarioIntroduction = createString("scenarioIntroduction");

    public final NumberPath<Long> scenarioSeq = createNumber("scenarioSeq", Long.class);

    public final StringPath scenarioTitle = createString("scenarioTitle");

    public final StringPath scenarioType = createString("scenarioType");

    public final NumberPath<Integer> userCount = createNumber("userCount", Integer.class);

    public final StringPath useYn = createString("useYn");

    public final StringPath writerCaution = createString("writerCaution");

    public final NumberPath<Integer> writerId = createNumber("writerId", Integer.class);

    public QScenarios(String variable) {
        super(Scenarios.class, forVariable(variable));
    }

    public QScenarios(Path<? extends Scenarios> path) {
        super(path.getType(), path.getMetadata());
    }

    public QScenarios(PathMetadata metadata) {
        super(Scenarios.class, metadata);
    }

}

