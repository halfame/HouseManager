package com.bwie.user.service.impl;

import com.bwie.common.domain.User;
import com.bwie.common.result.Result;
import com.bwie.user.mapper.UserMapper;
import com.bwie.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void delbyid(Integer userId) {
        userMapper.upddel(userId);
    }
}
