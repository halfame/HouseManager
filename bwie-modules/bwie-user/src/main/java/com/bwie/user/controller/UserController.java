package com.bwie.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.bwie.common.domain.Role;
import com.bwie.common.domain.User;
import com.bwie.common.domain.request.RoleShowRequest;
import com.bwie.common.domain.request.RoleUpdRequest;
import com.bwie.common.result.Result;
import com.bwie.user.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Log4j2
public class UserController {
@Autowired
private UserService userService;

@Autowired
private HttpServletRequest request;

    @PostMapping("findname")
    Result<User> findname(@RequestParam String userName){
        log.info("功能名称:xxx,请求URI:{},请求方式:{},请求参数:{}",
                request.getRequestURI(),request.getMethod(),userName);
        Result<User> result = userService.findname(userName);
        log.info("功能名称:xxx,请求URI:{},请求方式:{},响应结果:{}",
                request.getRequestURI(),request.getMethod(), JSONObject.toJSONString(result));
        return result;
    }




    @PostMapping("showr")
    Result showr(@RequestBody RoleShowRequest roleShowRequest){
        log.info("功能名称:xxx,请求URI:{},请求方式:{},请求参数:{}",
                request.getRequestURI(),request.getMethod(),JSONObject.toJSONString(roleShowRequest));
        Result result = userService.showr(roleShowRequest);
        log.info("功能名称:xxx,请求URI:{},请求方式:{},响应结果:{}",
                request.getRequestURI(),request.getMethod(), JSONObject.toJSONString(result));
        return result;
    }


    @PostMapping("delr")
    Result delr(@RequestBody Integer[] roleIds){
        log.info("功能名称:xxx,请求URI:{},请求方式:{},请求参数:{}",
                request.getRequestURI(),request.getMethod(),JSONObject.toJSONString(roleIds));
        userService.delr(roleIds);
        Result<String> result = Result.success("删除成功");
        log.info("功能名称:xxx,请求URI:{},请求方式:{},响应结果:{}",
                request.getRequestURI(),request.getMethod(), JSONObject.toJSONString(result));
        return result;
    }
    @PostMapping("delu")
    Result delu(@RequestBody Integer[] roleIds){
        log.info("功能名称:xxx,请求URI:{},请求方式:{},请求参数:{}",
                request.getRequestURI(),request.getMethod(),JSONObject.toJSONString(roleIds));
        userService.delu(roleIds);
        Result<String> result = Result.success("删除成功");
        log.info("功能名称:xxx,请求URI:{},请求方式:{},响应结果:{}",
                request.getRequestURI(),request.getMethod(), JSONObject.toJSONString(result));
        return result;
    }


    @PostMapping("addr")
    Result addr(@RequestBody Role role){
        log.info("功能名称:xxx,请求URI:{},请求方式:{},请求参数:{}",
                request.getRequestURI(),request.getMethod(),JSONObject.toJSONString(role));
        userService.addr(role);
        Result result = Result.success("删除成功");
        log.info("功能名称:xxx,请求URI:{},请求方式:{},响应结果:{}",
                request.getRequestURI(),request.getMethod(), JSONObject.toJSONString(result));
        return result;
    }

    @PostMapping("updr")
    Result updr(@RequestBody RoleUpdRequest role){
        log.info("功能名称:xxx,请求URI:{},请求方式:{},请求参数:{}",
                request.getRequestURI(),request.getMethod(),JSONObject.toJSONString(role));
        userService.updr(role);
        Result<String> result = Result.success("修改成功");
        log.info("功能名称:xxx,请求URI:{},请求方式:{},响应结果:{}",
                request.getRequestURI(),request.getMethod(), JSONObject.toJSONString(result));
        return result;
    }







}
