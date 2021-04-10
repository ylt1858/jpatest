package com.studuyjpa.repository;

import com.studuyjpa.entity.Student;
import com.studuyjpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testAdd() {
        Student student = new Student();
        student.setName("student");
        Teacher teacher = new Teacher();
        teacher.setName("teacher");
        teacher.setPhone("123");

        teacher.getStudents().add(student);
        student.setTeacher(teacher);

        //studentRepository.save(student);
        teacherRepository.save(teacher);

    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void addStudent(){
        Student student = new Student();
//        student.setSno(2l);
        student.setName("student1");
        studentRepository.save(student);
        System.err.println(student);
    }

    @Test
    @Transactional
    public void deleteStudent(){
      studentRepository.deleteById(5l);
//        studentRepository.deleteAll();
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void withStudentAddTeacherId(){
        Student one = studentRepository.getOne(3l);
        one.setTeacher(teacherRepository.getOne(1l));
        System.err.println(one);
        studentRepository.save(one);
    }

    @Test
    @Transactional
    public void getStudentById(){
        Optional<Student> student = studentRepository.findById(1l);
        System.err.println(student);
        System.err.println(student.get().getName());
    }
}