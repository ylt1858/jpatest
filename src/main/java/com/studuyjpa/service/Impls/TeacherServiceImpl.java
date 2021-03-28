package com.studuyjpa.service.Impls;

import com.studuyjpa.entity.Teacher;
import com.studuyjpa.repository.TeacherRepository;
import com.studuyjpa.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    @Override
    public void saveTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public Teacher getById(Long id) {
        return null;
    }

    @Override
    public List<Teacher> getTeachers() {
        return null;
    }

    @Override
    public void deleteTeacher(Teacher teacher) {

    }
}
