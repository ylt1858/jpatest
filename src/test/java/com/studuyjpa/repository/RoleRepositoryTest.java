package com.studuyjpa.repository;

import com.studuyjpa.entity.Role;
import com.studuyjpa.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@SpringBootTest
class RoleRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Test
    @Transactional
    //@Rollback(value = false)
    void test1() {
        User user = new User();
        user.setUserId(1l);
        user.setUsername("username1");

        Role role = new Role();
        role.setRoleName("roleName1");
        role.setRoleId(1l);

        Role role1 = new Role();
        role1.setRoleName("roleName2");
        role1.setRoleId(2l);

        Set<Role> roles = new HashSet<>();
        roles.add(role);
        roles.add(role1);

        user.setRoles(roles);
        user.getRoles().forEach(System.err::println);

        User save = userRepository.save(user);

        save.getRoles().forEach(System.err::println);
    }

    @Test
    @Transactional
    void test2() {
        List<Role> roleList = roleRepository.findAll();
        for (Role r : roleList) {
            r.getUsers().forEach(System.err::println);
        }
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void test3() {
        User user = new User();
        user.setUserId(2l);
        user.setUsername("username2");

        List<Role> roleList = roleRepository.findAll();
        int i = 1;
        Set<Role> roles = new HashSet<>();
        for (Role r : roleList) {
            roles.add(r);
        }

        user.setRoles(roles);
        userRepository.save(user);
    }

    @Test
    @Transactional
    void test4() {
        userRepository.deleteById(3l);
    }

}