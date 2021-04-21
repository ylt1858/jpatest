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
        user.setUserId(1L);
        user.setUsername("username1");

        Role role = new Role();
        role.setRoleName("roleName1");
        role.setRoleId(1L);

        Role role1 = new Role();
        role1.setRoleName("roleName2");
        role1.setRoleId(2L);

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
        user.setUserId(2L);
        user.setUsername("username2");

        List<Role> roleList = roleRepository.findAll();
        Set<Role> roles = new HashSet<>(roleList);

        user.setRoles(roles);
        userRepository.save(user);
    }

    @Test
    @Transactional
    void test4() {
        userRepository.deleteById(3L);
    }

    @Test
    @Transactional
    void test5() {
        User user = userRepository.getOne(3L);
        Set<Role> roles = user.getRoles();
        for (Role r:
                roles) {
            System.err.println(r);
        }

    }

    @Test
    @Transactional//No session
    void test6() {
        Role role = roleRepository.getOne(1L);
        Set<User> users = role.getUsers();
        users.forEach(System.err::print);
    }

    @Test
    @Transactional//No session
    @Rollback(value = false)
    void test7() {
        User user = new User();
        user.setUserId(11L);
        user.setUsername("name");
        Role role1 = new Role();
        role1.setRoleId(11L);
        Role role2 = new Role();
        role2.setRoleId(12L);
        // 空指针问题 多半是Set集合中没有new
        // private Set<xxx> xxx = new HashSet();
        user.addRole(role1);
        user.addRole(role2);

        userRepository.save(user);
    }

    @Test
    @Transactional//No session
    void test8() {
        User user = userRepository.getOne(1L);
        Set<Role> roleSet = new HashSet<>(user.getRoles());
        roleSet.forEach(System.err::println);
    }

    @Test         //getOne()懒加载 findById()快加载
    @Transactional//No session
    void test9() {
        Optional<User> user = userRepository.findById(1L);
        System.err.println(user.isPresent());// true or false
        user.ifPresent(value -> value.getRoles().forEach(System.err::println));
    }

    @Test           //getOne()懒加载 findById()快加载
    @Transactional  //No session
    void test10() {
        User user = userRepository.getOne(1L);
        System.err.println(user);
        for (Role r:
                user.getRoles()) {
            System.err.println(r);
        }
        /**
         * Hibernate: insert into user_role (user_id, role_id) values (?, ?)
         * user.addRole(roleRepository.getOne(3L));
         *
         * user.getRoles().remove(roleRepository.getOne(3L));
         * Hibernate: delete from user_role where user_id=? and role_id=?
         */
    }
}