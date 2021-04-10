package com.studuyjpa.entity;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.studuyjpa.entity.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ylt
 */

@Entity
@Data
@NoArgsConstructor
public class Teacher {
    /**
     * 工号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * cascade:级联
     * mappedBy:放弃
     */
    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
//    @JsonIgnore
    private Set<Student> students = new HashSet<>();

    public Teacher(Long id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
