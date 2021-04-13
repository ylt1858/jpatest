package com.studuyjpa.repository;

import com.studuyjpa.entity.Role;
import com.studuyjpa.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ylt
 * @date 2021/4/13 16:25
 */
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Test
    @Transactional
    void test1() {
        User one = userRepository.getOne(1l);
        Role role = roleRepository.getOne(11l);
        one.addRole(role);
        one.getRoles().forEach(System.err::println);
    }
}