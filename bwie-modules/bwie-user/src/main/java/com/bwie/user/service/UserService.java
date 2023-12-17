package com.bwie.user.service;

import com.bwie.common.domain.Role;
import com.bwie.common.domain.User;
import com.bwie.common.domain.request.RoleShowRequest;
import com.bwie.common.domain.request.RoleUpdRequest;
import com.bwie.common.result.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserService {
    Result<User> findname(String userName);


    Result showr(RoleShowRequest roleShowRequest);

    void delu(Integer[] roleIds);

    void delr(Integer[] roleIds);

    void addr(Role role);

    void updr(RoleUpdRequest role);
}
