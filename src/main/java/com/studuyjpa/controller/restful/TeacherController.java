package com.studuyjpa.controller.restful;

import com.studuyjpa.entity.Teacher;
import com.studuyjpa.repository.TeacherRepository;
import com.studuyjpa.service.Impls.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


/**
 * @author y'l'l
 */
@RestController
public class TeacherController {

    @Autowired
    TeacherServiceImpl teacherService;
    @Autowired
    TeacherRepository repository;

    /**
     * 获得所有老师的信息
     */
    @GetMapping("/teachers/{page}/{size}")
    public Page<Teacher> teachers(@PathVariable("page") int page,
                                  @PathVariable("size")int size) {
        Pageable pageable = PageRequest.of(page-1,size);
        return repository.findAll(pageable);
    }

    @GetMapping("/getTeacher/{id}")
    public Teacher getTeacher(@PathVariable Long id) {
        Teacher byId = teacherService.getById(id);
        return byId;
    }

    @GetMapping("/deleteTeacher/{id}")
    public String deleteTeacherById(@PathVariable Long id) {
        if (teacherService.getById(id) != null){
            teacherService.deleteTeacher(teacherService.getById(id));
            return "ok";
        }
        else {
            return "notOk";
        }
    }

    @PostMapping("/teacher/insert")
    public String insert(@RequestBody Teacher teacher) {
        Teacher save = repository.save(teacher);
        if (save != null) {
            return "ok!";
        }
        return "no";
    }

    @PostMapping("/teacher/update/{id}")
    public String update(@PathVariable("id") int id,
                         @RequestBody Teacher teacher) {
        Teacher byId = teacherService.getById((long) id);
        byId.setName(teacher.getName());
        byId.setEmail(teacher.getEmail());
        byId.setPhone(teacher.getPhone());
        repository.save(byId);
        return "ok";
    }

}
