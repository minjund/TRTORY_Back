package com.trpg.trpg_back.domain.board.dao;

import com.trpg.trpg_back.domain.board.dto.BoardsRequest;
import com.trpg.trpg_back.domain.board.dto.BoardsResponse;
import com.trpg.trpg_back.domain.board.entity.Boards;
import com.trpg.trpg_back.domain.board.entity.BoardsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardsRepository extends JpaRepository<Boards, Long>, BoardsCustomRepository {

    List<BoardsResponse> searchBoard(Long boardId, BoardsType BoardsType);
}
