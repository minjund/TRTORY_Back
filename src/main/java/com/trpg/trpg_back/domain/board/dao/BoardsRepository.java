package com.trpg.trpg_back.domain.board.dao;

import com.trpg.trpg_back.domain.board.entity.Boards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardsRepository extends JpaRepository<Boards, Long> {

}
