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
import java.util.Optional;
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

    @Test
    @Transactional
    void test5() {
        User user = userRepository.getOne(3l);
        Set<Role> roles = user.getRoles();
        for (Role r:
             roles) {
            System.err.println(r);
        }

    }

    @Test
    @Transactional//No session
    void test6() {
        Role role = roleRepository.getOne(1l);
        Set<User> users = role.getUsers();
        users.forEach(System.err::print);
    }

    @Test
    @Transactional//No session
    @Rollback(value = false)
    void test7() {
        User user = new User();
        user.setUserId(11l);
        user.setUsername("name");
        Role role1 = new Role();
        role1.setRoleId(11l);
        Role role2 = new Role();
        role2.setRoleId(12l);
        // 空指针问题 多半是Set集合中没有new
        // private Set<xxx> xxx = new HashSet();
        user.addRole(role1);
        user.addRole(role2);

        userRepository.save(user);
    }

    @Test
    @Transactional//No session
    void test8() {
        User user = userRepository.getOne(1l);
        Set<Role> roleSet = new HashSet<>();
        for (Role r:
             user.getRoles()) {
            roleSet.add(r);
        }
        roleSet.forEach(System.err::println);
    }

    @Test
    @Transactional//No session
    void test9() {
        Optional<User> user = userRepository.findById(1l);//getOne()懒加载 findById()快加载
        user.get().getRoles().forEach(System.err::println);
    }
}