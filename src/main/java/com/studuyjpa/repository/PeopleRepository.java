package com.studuyjpa.repository;

import com.studuyjpa.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author ylt
 * @date 2021/5/20 10:39
 */
@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {
    /**
     * findMaxLeng
     * @return Integer
     */
    @Query(value = "select max(People.length) from People where People.weigh<95"
            ,nativeQuery = true)
    Integer findMaxLength();
}
