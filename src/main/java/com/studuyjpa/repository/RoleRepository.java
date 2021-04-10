package com.studuyjpa.repository;

import com.studuyjpa.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author ylt
 * @date 2021/4/1 19:56
 */
public interface RoleRepository extends JpaRepository<Role,Long>, JpaSpecificationExecutor<Role> {
}
