package com.bwie.auth.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bwie.auth.feign.AuthFeign;
import com.bwie.auth.service.AuthService;
import com.bwie.auth.util.ImageVerificationCode;
import com.bwie.common.constants.JwtConstants;
import com.bwie.common.constants.TokenConstants;
import com.bwie.common.domain.Role;
import com.bwie.common.domain.User;
import com.bwie.common.domain.request.LoginRequest;
import com.bwie.common.domain.response.JwtResponse;
import com.bwie.common.result.Result;
import com.bwie.common.utils.JwtUtils;
import com.bwie.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthFeign authFeign;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private StringRedisTemplate redisTemplate;



    @Override
    public Result getImage()  {
        ImageVerificationCode imageVerificationCode = new ImageVerificationCode();
        BufferedImage image = imageVerificationCode.getImage();
        String text = imageVerificationCode.getText();
        redisTemplate.opsForValue().set("text",text);
        try {
            ImageVerificationCode.output(image,response.getOutputStream() );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Result.success(text);
    }

    @Override
    public Result login(LoginRequest loginRequest) {
        if(StringUtils.isAllBlank(loginRequest.getUserName(),loginRequest.getUserPwd(),loginRequest.getUserCode())){
            return Result.error("不能为空");
        }

        Result<User> findname = authFeign.findname(loginRequest.getUserName());
        User data = findname.getData();
        if(null==data){
            return Result.error("用户名不存在");
        }
        if(!loginRequest.getUserPwd().equals(data.getUserPwd())){
            return Result.error("密码错误");
        }
        if(!redisTemplate.hasKey("text")){
            return Result.error("验证码失效");
        }
        String s = redisTemplate.opsForValue().get("text");
        if(!s.equals(loginRequest.getUserCode())){
            return Result.error("验证码错误");
        }
        String key = UUID.randomUUID().toString().replaceAll("-", "");
        HashMap<String, Object> map = new HashMap<>();
        map.put(JwtConstants.USER_KEY,key);
        String token = JwtUtils.createToken(map);
        redisTemplate.opsForValue().set(TokenConstants.LOGIN_TOKEN_KEY+key, JSONObject.toJSONString(data),15, TimeUnit.MINUTES);
        JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.setExpireTime("15MIN");
        jwtResponse.setToken(token);
        return Result.success(jwtResponse);
    }

    @Override
    public Result Info() {
        String header = request.getHeader(TokenConstants.TOKEN);
        String userKey = JwtUtils.getUserKey(header);
        String s = redisTemplate.opsForValue().get(TokenConstants.LOGIN_TOKEN_KEY + userKey);
        User user = JSONObject.parseObject(s, User.class);
        return Result.success(user);
    }

    @Override
    public Result roleshow(String roleName) {
        Result result = authFeign.showr(roleName);
        return result;
    }

    /**
     * 逻辑删除角色
     * 根据id改状态
     *
     * @param roleIds
     * @return
     */

    @Override
    public Result del(Integer[] roleIds) {
        return null;
    }

    @Override
    public Result addrole(Role role) {
        return null;
    }




}
