package com.bwie.user.service;

import com.bwie.common.domain.User;
import com.bwie.common.result.Result;
import org.springframework.web.bind.annotation.RequestParam;

import javax.management.relation.Role;

public interface UserService {
    Result<User> findname(String userName);

    void delbyid(Integer userId);
    Result showr(String roleName);
}
