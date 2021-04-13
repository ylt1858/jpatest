package com.studuyjpa.service.Impls;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.studuyjpa.entity.QUser;
import com.studuyjpa.entity.User;
import com.studuyjpa.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ylt
 * @date 2021/4/13 16:34
 */
@Service
public class UserServiceImpl implements UserService {

    JPAQueryFactory queryFactory;

    @Override
    public List<User> getRolesBy() {
        return queryFactory.select(QUser.user)
                .from(QUser.user)
                .where(QUser.user.userId.eq(1L))
                .fetch();
    }
}
