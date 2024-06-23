package com.trpg.trpg_back.domain.scenario.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QScenariosComment is a Querydsl query type for ScenariosComment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QScenariosComment extends EntityPathBase<ScenariosComment> {

    private static final long serialVersionUID = 1100012458L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QScenariosComment scenariosComment = new QScenariosComment("scenariosComment");

    public final com.trpg.trpg_back.global.util.QBaseEntity _super = new com.trpg.trpg_back.global.util.QBaseEntity(this);

    public final StringPath commentContent = createString("commentContent");

    public final NumberPath<Long> commentSeq = createNumber("commentSeq", Long.class);

    public final StringPath commentTitle = createString("commentTitle");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> mod_date = _super.mod_date;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> reg_date = _super.reg_date;

    public final QScenarios scenarioId;

    public final StringPath userId = createString("userId");

    public final StringPath useYn = createString("useYn");

    public QScenariosComment(String variable) {
        this(ScenariosComment.class, forVariable(variable), INITS);
    }

    public QScenariosComment(Path<? extends ScenariosComment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QScenariosComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QScenariosComment(PathMetadata metadata, PathInits inits) {
        this(ScenariosComment.class, metadata, inits);
    }

    public QScenariosComment(Class<? extends ScenariosComment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.scenarioId = inits.isInitialized("scenarioId") ? new QScenarios(forProperty("scenarioId")) : null;
    }

}

