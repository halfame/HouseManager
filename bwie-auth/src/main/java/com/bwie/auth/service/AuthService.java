package com.bwie.auth.service;

import com.bwie.common.domain.User;
import com.bwie.common.domain.request.LoginRequest;
import com.bwie.common.result.Result;

import java.io.IOException;

public interface AuthService {
   Result getImage() throws IOException;
   Result login(LoginRequest loginRequest);
   Result Info();
   Result del(Integer userId);
   Result adduser(User user);
}
