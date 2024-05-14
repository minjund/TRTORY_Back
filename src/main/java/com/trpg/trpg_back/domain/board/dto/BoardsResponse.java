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

    public BoardsResponse(Long boardId, String boardTitle, String boardContents, Integer writerId) {
        this.board_id = boardId;
        this.board_title = boardTitle;
        this.board_contents = boardContents;
        this.writer_id = writerId;
        // board_type과 use_yn 필드는 적절한 값으로 설정하거나, 추가적인 파라미터를 받아 설정해야 합니다.
    }

}
