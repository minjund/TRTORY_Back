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
    @Column(name = "board_seq", columnDefinition = "bigint", nullable = false)
    private long boardSeq;

    @Column(name = "board_id", columnDefinition = "bigint", nullable = false)
    private long boardId;

    @Column(name = "board_title", columnDefinition = "varchar(45)", nullable = false)
    private String boardTitle;

    @Column(name = "board_contents", columnDefinition = "varchar(500)", nullable = false)
    private String boardContents;

    @Column(name = "board_type", columnDefinition = "varchar(45)", nullable = false)
    private String boardType;

    @Column(name = "writer_id", columnDefinition = "int", nullable = false)
    private int writerId;

    @Column(name = "use_yn", columnDefinition = "varchar(2)", nullable = false)
    private String useYn;

    public void createBoard(String board_title, String board_contents, BoardsType board_type, int writer_id){

        this.boardId = this.boardSeq;
        this.boardTitle = board_title;
        this.boardContents = board_contents;
        this.boardType = board_type.name();
        this.writerId = writer_id;
        this.useYn = "Y";
    }


    public void updateBoard(String boardTitle, String boardContents, BoardsType boardType, int writerId) {
        this.boardTitle = boardTitle;
        this.boardContents = boardContents;
        this.boardType = boardType.name();
        this.writerId = writerId;

    }
}
