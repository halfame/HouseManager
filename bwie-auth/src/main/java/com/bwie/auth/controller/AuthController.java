package com.bwie.auth.controller;

import com.alibaba.fastjson.JSONObject;
import com.bwie.auth.service.AuthService;
import com.bwie.common.domain.Role;
import com.bwie.common.domain.User;
import com.bwie.common.domain.request.LoginRequest;
import com.bwie.common.domain.request.RoleShowRequest;
import com.bwie.common.domain.request.RoleUpdRequest;
import com.bwie.common.result.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@Log4j2
public class AuthController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private AuthService authService;

    @GetMapping("getImage")
    public Result getImage() throws IOException {
        log.info("功能名称:xxx,请求URI:{},请求方式:{}",
                request.getRequestURI(),request.getMethod());
        Result result = authService.getImage();
        log.info("功能名称:xxx,请求URI:{},请求方式:{},响应结果:{}",
                request.getRequestURI(),request.getMethod(), JSONObject.toJSONString(result));
        return result;
    }

    @PostMapping("login")
    public Result login(@RequestBody LoginRequest loginRequest){
        log.info("功能名称:xxx,请求URI:{},请求方式:{},请求参数:{}",
                request.getRequestURI(),request.getMethod(),JSONObject.toJSONString(loginRequest));
        Result result = authService.login(loginRequest);
        log.info("功能名称:xxx,请求URI:{},请求方式:{},响应结果:{}",
                request.getRequestURI(),request.getMethod(), JSONObject.toJSONString(result));
        return result;
    }

    @GetMapping("Info")
    public Result<User> Info(){
        log.info("功能名称:xxx,请求URI:{},请求方式:{}",
                request.getRequestURI(),request.getMethod());
        User user = authService.Info();
        Result<User> info = Result.success(user);
        log.info("功能名称:xxx,请求URI:{},请求方式:{},响应结果:{}",
                request.getRequestURI(),request.getMethod(), JSONObject.toJSONString(info));
        return info;
    }


    @PostMapping("del")
    public Result delrole(@RequestBody Integer[] roleIds){
        log.info("功能名称:xxx,请求URI:{},请求方式:{},请求参数:{}",
                request.getRequestURI(),request.getMethod(),roleIds);
        Result result = authService.delrole(roleIds);
        log.info("功能名称:xxx,请求URI:{},请求方式:{},响应结果:{}",
                request.getRequestURI(),request.getMethod(), JSONObject.toJSONString(result));
        return result;
    }


    @PostMapping("showrole")
    public Result showrole(@RequestParam RoleShowRequest roleShowRequest){
        log.info("功能名称:xxx,请求URI:{},请求方式:{},请求参数:{}",
                request.getRequestURI(),request.getMethod(),JSONObject.toJSONString(roleShowRequest));
        Result result = authService.roleshow(roleShowRequest);
        log.info("功能名称:xxx,请求URI:{},请求方式:{},响应结果:{}",
                request.getRequestURI(),request.getMethod(), JSONObject.toJSONString(result));
        return result;
    }


    @PostMapping("addrole")
    public Result addrole(@RequestBody Role role){
        log.info("功能名称:xxx,请求URI:{},请求方式:{},请求参数:{}",
                request.getRequestURI(),request.getMethod(),JSONObject.toJSONString(role));
        Result result = authService.addrole(role);
        log.info("功能名称:xxx,请求URI:{},请求方式:{},响应结果:{}",
                request.getRequestURI(),request.getMethod(), JSONObject.toJSONString(result));
        return result;
    }


    @PostMapping("updrole")
    public Result updrole(@RequestBody RoleUpdRequest role){
        log.info("功能名称:xxx,请求URI:{},请求方式:{},请求参数:{}",
                request.getRequestURI(),request.getMethod(),JSONObject.toJSONString(role));
        Result result = authService.updrole(role);
        log.info("功能名称:xxx,请求URI:{},请求方式:{},响应结果:{}",
                request.getRequestURI(),request.getMethod(), JSONObject.toJSONString(result));
        return result;
    }






}
