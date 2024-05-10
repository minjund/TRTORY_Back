package com.trpg.trpg_back.domain.board.dto;

import com.trpg.trpg_back.domain.board.entity.Boards;
import lombok.Data;

@Data
public class BoardsResponse {

    private Long board_id;
    private String board_title;
    private String board_contents;
    private String board_type;
    private int writer_id;
    private String use_yn;

    public BoardsResponse(long boardId) {
        this.board_id = boardId;
    }

    public BoardsResponse(Boards boards) {
        board_id = boards.getBoardId();
        board_title = boards.getBoardTitle();
        board_contents = boards.getBoardContents();
        board_type = boards.getBoardType();
        writer_id = boards.getWriterId();
        use_yn = boards.getUseYn();
    }
}
