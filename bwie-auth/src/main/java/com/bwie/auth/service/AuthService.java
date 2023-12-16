package com.bwie.auth.service;

import com.bwie.common.domain.Role;
import com.bwie.common.domain.User;
import com.bwie.common.domain.request.LoginRequest;
import com.bwie.common.result.Result;

import java.io.IOException;

public interface AuthService {
   Result getImage() throws IOException;
   Result login(LoginRequest loginRequest);
   Result Info();
   Result roleshow(String roleName);
   Result del(Integer[] roleIds);

   Result addrole(Role role);



























}
