package com.trpg.trpg_back.domain.board.entity;


import com.trpg.trpg_back.global.util.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "board")
public class Boards extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long board_id;

    @Column(name = "board_title", columnDefinition = "varchar(45)", nullable = false)
    private String board_title;

    @Column(name = "board_contents", columnDefinition = "varchar(500)", nullable = false)
    private String board_contents;

    @Column(name = "board_type", columnDefinition = "varchar(45)", nullable = false)
    private String board_type;

    @Column(name = "writer_id", columnDefinition = "varchar(45)", nullable = false)
    private String writer_id;

    @Column(name = "use_yn", columnDefinition = "varchar(2)", nullable = false)
    private String use_yn;

    public static Boards createBoard(String board_title, String board_contents, String board_type, String writer_id){
        Boards boards = new Boards();
        boards.board_title = board_title;
        boards.board_contents = board_contents;
        boards.board_type = board_type;
        boards.writer_id = writer_id;
        boards.use_yn = "Y";
        return boards;
    }



}
