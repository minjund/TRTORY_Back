package com.trpg.trpg_back.domain.board.dao;


import com.trpg.trpg_back.domain.board.dto.BoardsResponse;
import com.trpg.trpg_back.domain.board.entity.BoardsType;

import java.util.List;

public interface BoardsCustomRepository {

    List<BoardsResponse> searchBoard(Long boardId, BoardsType BoardsType);
}
