package com.bwie.auth.controller;

import com.alibaba.fastjson.JSONObject;
import com.bwie.auth.service.AuthService;
import com.bwie.common.domain.request.LoginRequest;
import com.bwie.common.result.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public Result Info(){
        log.info("功能名称:xxx,请求URI:{},请求方式:{}",
                request.getRequestURI(),request.getMethod());
        Result info = authService.Info();
        log.info("功能名称:xxx,请求URI:{},请求方式:{},响应结果:{}",
                request.getRequestURI(),request.getMethod(), JSONObject.toJSONString(info));
        return info;
    }


    @PostMapping("del")
    public Result del(Integer userId){
        log.info("功能名称:xxx,请求URI:{},请求方式:{},请求参数:{}",
                request.getRequestURI(),request.getMethod(),userId);
        Result result = authService.del(userId);
        log.info("功能名称:xxx,请求URI:{},请求方式:{},响应结果:{}",
                request.getRequestURI(),request.getMethod(), JSONObject.toJSONString(result));
        return result;
    }













}
