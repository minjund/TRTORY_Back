package com.trpg.trpg_back.domain.user.dao.jpa;

import com.trpg.trpg_back.domain.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
    Optional<Users> findByUserNickname(String userNickname);
    Optional<Users> findByUserEmail(String userEmail);

}
