package com.studuyjpa.repository;

import com.studuyjpa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ylt
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>, JpaSpecificationExecutor<Teacher> {
    /**
     * 通过名字进行模糊查询
     * @param name 名字
     * @return Teacher List
     */
    List<Teacher> findByNameLike(String name);
}
