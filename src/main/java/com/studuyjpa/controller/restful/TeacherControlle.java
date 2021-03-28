package com.studuyjpa.controller.restful;

import com.studuyjpa.entity.Teacher;
import com.studuyjpa.service.Impls.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherControlle {

    @Autowired
    TeacherServiceImpl teacherService;

    /**
     * 获得所有老师的信息
     */
    @GetMapping("/teachers")
    public List<Teacher> teachers() {
        return teacherService.getTeachers();
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
            return "deleteOk";
        }
        else {
            return "notOk";
        }
    }

}
