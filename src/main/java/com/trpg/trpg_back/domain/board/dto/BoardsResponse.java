package com.trpg.trpg_back.domain.board.dto;

import lombok.Data;

@Data
public class BoardsResponse {

    private Long board_id;
    private String board_title;
    private String board_contents;
    private String board_type;
    private String writer_id;
    private String use_yn;

    public BoardsResponse(long boardId) {
        this.board_id = boardId;
    }
}
