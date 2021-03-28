package com.studuyjpa.service;

import com.studuyjpa.entity.Teacher;

import java.util.List;

public interface TeacherService {

    /**
     * 保存老师
     * @param teacher 老师信息
     */
    void saveTeacher(Teacher teacher);

    /**
     * 根据工号查询老师
     * @param id 工号
     * @return 老师信息
     */
    Teacher getById(Long id);

    /**
     * 获得所有老师信息
     * @return 老师信息
     */
    List<Teacher> getTeachers();

    /**
     * 删除老师
     * @param teacher 工号
     */
    void deleteTeacher(Teacher teacher);

}
