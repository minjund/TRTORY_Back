package com.trpg.trpg_back.domain.board.dao;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.trpg.trpg_back.domain.board.dto.BoardsRequest;
import com.trpg.trpg_back.domain.board.dto.BoardsResponse;
import com.trpg.trpg_back.domain.board.entity.BoardsType;
import com.trpg.trpg_back.domain.board.entity.QBoards;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.trpg.trpg_back.domain.board.entity.QBoards.boards;
import static org.springframework.util.ObjectUtils.isEmpty;

@RequiredArgsConstructor
public class BoardsRepositoryImpl implements BoardsCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<BoardsResponse> searchBoard(Long boardId, BoardsType BoardsType) {

        return queryFactory.
                select(Projections.constructor(BoardsResponse.class,
                        boards.boardId,
                        boards.boardTitle,
                        boards.boardContents,
                        boards.writerId))
                .from(boards)
                .where(boardsTypeEq(BoardsType.name()),
                        boardIdEq(boardId))
                .fetch();
    }

    private BooleanExpression boardIdEq(Long BoardId) {
        return isEmpty(BoardId) ? null : boards.boardId.eq(BoardId);
    }

    private BooleanExpression boardsTypeEq(String BoardsTypeName) {
        return isEmpty(BoardsTypeName) ? null : boards.boardType.eq(BoardsTypeName);
    }
}
