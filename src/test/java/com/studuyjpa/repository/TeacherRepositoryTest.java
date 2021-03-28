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
        Teacher teacher = new Teacher();
        teacher.setId((long) 1);
        teacher.setName("test");
        teacher.setPhone("12312344321");
        teacher.setEmail("123@163.com");
        Teacher save = teacherRepository.save(teacher);
        System.err.println(save);
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