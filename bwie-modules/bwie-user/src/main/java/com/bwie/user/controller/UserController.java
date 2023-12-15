package com.bwie.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.bwie.common.domain.User;
import com.bwie.common.result.Result;
import com.bwie.user.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("bwie-user")
    Result<User> findname(@RequestParam String userName){
        log.info("功能名称:xxx,请求URI:{},请求方式:{},请求参数:{}",
                request.getRequestURI(),request.getMethod(),userName);
        Result<User> result = userService.findname(userName);
        log.info("功能名称:xxx,请求URI:{},请求方式:{},响应结果:{}",
                request.getRequestURI(),request.getMethod(), JSONObject.toJSONString(result));
        return result;
    }


    @PostMapping("bwie-user")
    Result<String> delbyid(@RequestParam Integer userId){
        log.info("功能名称:xxx,请求URI:{},请求方式:{},请求参数:{}",
                request.getRequestURI(),request.getMethod(),userId);
        userService.delbyid(userId);
        Result<String> result = Result.success("逻辑删除成功");
        log.info("功能名称:xxx,请求URI:{},请求方式:{},响应结果:{}",
                request.getRequestURI(),request.getMethod(), JSONObject.toJSONString(result));
        return result;
    }
}
