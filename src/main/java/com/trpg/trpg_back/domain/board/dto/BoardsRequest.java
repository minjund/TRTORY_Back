package com.trpg.trpg_back.domain.board.dto;

import com.trpg.trpg_back.domain.board.entity.BoardsType;
import lombok.Builder;
import lombok.Data;

@Data
public class BoardsRequest {
    Long boardSeq;
    Long boardId;
    String boardTitle;
    BoardsType boardType;
    String boardContents;
    int writerId;

}
