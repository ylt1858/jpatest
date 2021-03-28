package com.studuyjpa.service.Impls;

import com.studuyjpa.entity.Teacher;
import com.studuyjpa.repository.TeacherRepository;
import com.studuyjpa.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Teacher> byId = teacherRepository.findById(id);
        return byId.orElse(null);
    }

    @Override
    public List<Teacher> getTeachers() {
        List<Teacher> all = teacherRepository.findAll();
        return all;
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        teacherRepository.delete(teacher);
    }
}
