package com.studuyjpa.service;

import com.studuyjpa.entity.User;

import java.util.List;

/**
 * @author ylt
 * @date 2021/4/13 16:32
 */
public interface UserService {
    /**
     * 通过userid查找User
     * @return Role List
     */
    List<User> getRolesBy();
}
