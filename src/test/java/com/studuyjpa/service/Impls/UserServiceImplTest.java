package com.studuyjpa.service.Impls;

import com.querydsl.core.Tuple;
import com.studuyjpa.entity.QRole;
import com.studuyjpa.entity.QUser;
import com.studuyjpa.entity.Role;
import com.studuyjpa.entity.User;
import com.studuyjpa.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ylt
 * @date 2021/4/13 16:49
 */
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    @Transactional
    void getRoles() {
        List<User> result = userService.getRolesBy();
        //对多元组取出数据,这个和select时的数据相匹配
//        for (Role row : result) {
//            System.out.println("Role:"+row);
//            System.out.println("--------------------");
//        }
        System.err.println(result);
    }
}