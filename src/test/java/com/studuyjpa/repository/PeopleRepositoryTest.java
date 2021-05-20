package com.studuyjpa.repository;

import com.studuyjpa.entity.People;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ylt
 * @date 2021/5/20 10:47
 */
@SpringBootTest
public class PeopleRepositoryTest {
    @Autowired
    private PeopleRepository repository;

    @Test
    @Transactional
    @Rollback(value = false)
    void create(){
        People people = new People();
        for (long i = 1L; i<=5L; i++) {
            people.setId(i);
            people.setLength((int) (i+100));
            people.setWeigh((int) (i+90));
            repository.save(people);
        }
    }

    @Test
    void findMax(){
        Integer maxLength = repository.findMaxLength();
        System.err.println(maxLength);
    }
}
