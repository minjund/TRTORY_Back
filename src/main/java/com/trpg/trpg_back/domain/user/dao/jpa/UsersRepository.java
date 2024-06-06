package com.trpg.trpg_back.domain.user.dao.jpa;

import com.trpg.trpg_back.domain.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
    Users findByUserNickname(String userNickname);
}
