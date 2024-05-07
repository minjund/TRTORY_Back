package com.trpg.trpg_back.domain.board.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class BoardsRequest {

    String board_title;
    String board_contents;
    String board_type;
    String writer_id;

}
