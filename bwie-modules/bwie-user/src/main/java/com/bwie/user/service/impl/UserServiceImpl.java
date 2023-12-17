package com.bwie.user.service.impl;

import com.bwie.common.domain.Role;
import com.bwie.common.domain.User;
import com.bwie.common.domain.request.RoleShowRequest;
import com.bwie.common.domain.request.RoleUpdRequest;
import com.bwie.common.result.Result;
import com.bwie.user.mapper.UserMapper;
import com.bwie.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public Result<User> findname(String userName) {
        User findname = userMapper.findname(userName);
        return Result.success(findname);

    }



    @Override
    public Result showr( RoleShowRequest roleShowRequest) {

        List<com.bwie.common.domain.Role> showr = userMapper.showr(roleShowRequest);
        return Result.success(showr);
    }

    @Override
    public void delu(Integer[] roleIds) {
        userMapper.updu(roleIds);
    }

    @Override
    public void delr(Integer[] roleIds) {
        userMapper.delr(roleIds);
    }

    @Override
    public void addr(Role role) {
        userMapper.addr(role);

    }

    @Override
    public void updr(RoleUpdRequest role) {
        userMapper.updr(role);
    }
}
