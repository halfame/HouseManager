package com.bwie.auth.feign;

import com.bwie.common.domain.Role;
import com.bwie.common.domain.User;
import com.bwie.common.domain.request.RoleShowRequest;
import com.bwie.common.domain.request.RoleUpdRequest;
import com.bwie.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("bwie-user")
public interface AuthFeign {
    @PostMapping("findname")
    Result<User> findname(@RequestParam String userName);


    @PostMapping("showr")
    Result showr(@RequestBody RoleShowRequest roleShowRequest);
    @PostMapping("delr")
    Result delr(@RequestBody Integer[] roleIds);
    @PostMapping("delu")
    Result delu(@RequestBody Integer[] roleIds);
    @PostMapping("addr")
    Result addr(@RequestBody Role role);
    @PostMapping("updr")
    Result updr(@RequestBody RoleUpdRequest role);
}
