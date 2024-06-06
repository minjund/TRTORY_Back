package com.trpg.trpg_back.domain.user.dao.redis;

import com.trpg.trpg_back.domain.user.entity.RedisUsers;
import com.trpg.trpg_back.domain.user.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisUsersRepository extends CrudRepository<RedisUsers, Long> {
}
