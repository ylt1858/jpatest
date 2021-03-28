package com.studuyjpa.repository;

import com.studuyjpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    void savaTest() {
        for (long a=3;a<10;a++) {
            Teacher save = teacherRepository.save(
                    new Teacher(a, "name" + a, "phone" + a, "email" + a)
            );
            System.err.println(save);
        }

    }

    @Test
    void queryTeacherList() {
        List<Teacher> all = teacherRepository.findAll();
        all.forEach(System.err::println);
    }

    @Test
    void deleteTeacher() {
        teacherRepository.deleteById((long) 1);
    }
}