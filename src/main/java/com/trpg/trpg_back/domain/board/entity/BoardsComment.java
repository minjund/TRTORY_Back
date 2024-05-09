package com.trpg.trpg_back.domain.board.entity;

import com.trpg.trpg_back.global.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "board_comment")
@Getter
public class BoardsComment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentSeq;

    @Column(name = "comment_title", columnDefinition = "varchar(45)", nullable = false)
    private String commentTitle;

    @Column(name = "comment_content", columnDefinition = "varchar(45)", nullable = false)
    private String commentContent;

    @Column(name = "user_id", columnDefinition = "varchar(45)", nullable = false)
    private String userId;

    @Column(name = "use_yn", columnDefinition = "varchar(45)", nullable = false)
    private String useYn;

    @JoinColumn(name = "board_id", columnDefinition = "bigint", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Boards boardId;
}