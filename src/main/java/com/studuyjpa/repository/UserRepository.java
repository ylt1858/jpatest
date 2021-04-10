package com.studuyjpa.repository;

import com.studuyjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author ylt
 * @date 2021/4/1 19:54
 */
public interface UserRepository extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {
}
