package com.trpg.trpg_back.repository;

import com.trpg.trpg_back.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface userRepository extends JpaRepository<user, Long> {
    List<user> findAll();

    @Override
    <S extends user> S save(S entity);
}
