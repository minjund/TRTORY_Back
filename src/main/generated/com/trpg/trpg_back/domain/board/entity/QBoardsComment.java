package com.trpg.trpg_back.domain.board.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoardsComment is a Querydsl query type for BoardsComment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardsComment extends EntityPathBase<BoardsComment> {

    private static final long serialVersionUID = -2034782608L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoardsComment boardsComment = new QBoardsComment("boardsComment");

    public final com.trpg.trpg_back.global.util.QBaseEntity _super = new com.trpg.trpg_back.global.util.QBaseEntity(this);

    public final QBoards boardId;

    public final StringPath commentContent = createString("commentContent");

    public final NumberPath<Long> commentSeq = createNumber("commentSeq", Long.class);

    public final StringPath commentTitle = createString("commentTitle");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> mod_date = _super.mod_date;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> reg_date = _super.reg_date;

    public final StringPath userId = createString("userId");

    public final StringPath useYn = createString("useYn");

    public QBoardsComment(String variable) {
        this(BoardsComment.class, forVariable(variable), INITS);
    }

    public QBoardsComment(Path<? extends BoardsComment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoardsComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoardsComment(PathMetadata metadata, PathInits inits) {
        this(BoardsComment.class, metadata, inits);
    }

    public QBoardsComment(Class<? extends BoardsComment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.boardId = inits.isInitialized("boardId") ? new QBoards(forProperty("boardId")) : null;
    }

}

