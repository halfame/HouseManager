package com.bwie.auth.feign;

import com.bwie.common.domain.User;
import com.bwie.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("bwie-user")
public interface AuthFeign {
    @PostMapping("bwie-user")
    Result<User> findname(@RequestParam String userName);
    @PostMapping("bwie-user")
    Result delbyid(@RequestParam Integer userId);
}
