package com.trpg.trpg_back.domain.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUsers is a Querydsl query type for Users
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUsers extends EntityPathBase<Users> {

    private static final long serialVersionUID = -1031074753L;

    public static final QUsers users = new QUsers("users");

    public final com.trpg.trpg_back.global.util.QBaseEntity _super = new com.trpg.trpg_back.global.util.QBaseEntity(this);

    public final StringPath email = createString("email");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> mod_date = _super.mod_date;

    public final StringPath nickName = createString("nickName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> reg_date = _super.reg_date;

    public final StringPath userDiscordId = createString("userDiscordId");

    public final StringPath userNickname = createString("userNickname");

    public final StringPath userPw = createString("userPw");

    public final NumberPath<Long> userSeq = createNumber("userSeq", Long.class);

    public final StringPath useYn = createString("useYn");

    public QUsers(String variable) {
        super(Users.class, forVariable(variable));
    }

    public QUsers(Path<? extends Users> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUsers(PathMetadata metadata) {
        super(Users.class, metadata);
    }

}

