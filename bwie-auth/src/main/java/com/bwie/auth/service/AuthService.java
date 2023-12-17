package com.bwie.auth.service;

import com.bwie.common.domain.Role;
import com.bwie.common.domain.User;
import com.bwie.common.domain.request.LoginRequest;
import com.bwie.common.domain.request.RoleShowRequest;
import com.bwie.common.domain.request.RoleUpdRequest;
import com.bwie.common.result.Result;

import java.io.IOException;

public interface AuthService {
   Result getImage() throws IOException;
   Result login(LoginRequest loginRequest);
   User Info();
   Result roleshow(RoleShowRequest roleShowRequest);
   Result delrole(Integer[] roleIds);

   Result addrole(Role role);
   Result updrole(RoleUpdRequest role);




























}
