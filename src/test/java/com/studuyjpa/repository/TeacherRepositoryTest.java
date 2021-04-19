package com.studuyjpa.repository;

import com.studuyjpa.entity.Student;
import com.studuyjpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;

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
        teacherRepository.deleteById(8l);
    }

    @Test
    @Transactional
    public void getTeacherById(){
        Teacher one = teacherRepository.getOne(1l);
        one.getStudents().forEach(System.err::println);
        System.err.println(one.getName());
    }

    @Test
    @Transactional
    void findByNameLikeTest() {
        List<Teacher> byNameLike = teacherRepository.findByNameLike("%");
        for (Teacher teacher : byNameLike) {
            System.err.println(teacher);
        }
    }
}
