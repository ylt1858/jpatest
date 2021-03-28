package com.studuyjpa.repository;

import com.studuyjpa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ylt
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
