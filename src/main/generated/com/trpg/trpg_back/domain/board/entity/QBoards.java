package com.trpg.trpg_back.domain.board.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoards is a Querydsl query type for Boards
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoards extends EntityPathBase<Boards> {

    private static final long serialVersionUID = -1637597969L;

    public static final QBoards boards = new QBoards("boards");

    public final com.trpg.trpg_back.global.util.QBaseEntity _super = new com.trpg.trpg_back.global.util.QBaseEntity(this);

    public final StringPath boardComment = createString("boardComment");

    public final StringPath boardContents = createString("boardContents");

    public final NumberPath<Long> boardId = createNumber("boardId", Long.class);

    public final NumberPath<Long> boardSeq = createNumber("boardSeq", Long.class);

    public final StringPath boardTitle = createString("boardTitle");

    public final StringPath boardType = createString("boardType");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> mod_date = _super.mod_date;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> reg_date = _super.reg_date;

    public final StringPath useYn = createString("useYn");

    public final NumberPath<Integer> writerId = createNumber("writerId", Integer.class);

    public QBoards(String variable) {
        super(Boards.class, forVariable(variable));
    }

    public QBoards(Path<? extends Boards> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoards(PathMetadata metadata) {
        super(Boards.class, metadata);
    }

}

