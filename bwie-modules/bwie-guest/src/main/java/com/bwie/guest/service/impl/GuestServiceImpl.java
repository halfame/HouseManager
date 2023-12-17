package com.bwie.guest.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bwie.common.constants.TokenConstants;
import com.bwie.common.domain.Complaint;
import com.bwie.common.domain.Follow;
import com.bwie.common.domain.User;
import com.bwie.common.result.Result;
import com.bwie.common.utils.JwtUtils;
import com.bwie.guest.mapper.GuestMapper;
import com.bwie.guest.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestMapper guestMapper;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private HttpServletRequest request;

    //获取当前登录人
//    public User getLogon(){
//        String token = request.getHeader("token");
//        String str = redisTemplate.opsForValue().get("logon:" + token);
//        User user = JSON.parseObject(str, User.class);
//        return user;
//    }

    public Result<User> getLogon() {
        String header = request.getHeader(TokenConstants.TOKEN);
        String userKey = JwtUtils.getUserKey(header);
        String s = redisTemplate.opsForValue().get(TokenConstants.LOGIN_TOKEN_KEY + userKey);
        User user = JSONObject.parseObject(s, User.class);
        return Result.success(user);
    }

    @Override
    public Result complaint(String guestName) {
        List<Complaint> list = guestMapper.complaint(guestName);
        return Result.success(list);
    }

    @Override
    public Result addComplaint(Complaint complaint) {
        Integer res = guestMapper.addComplaint(complaint);
        return res>0?Result.success("添加成功"):Result.error("添加失败");
    }

    @Override
    public Result receive(@RequestBody Complaint complaint){
        Result<User> userResult = getLogon();
        User logon = userResult.getData();
        Integer res = guestMapper.receive(logon,complaint);
        return res>0?Result.success("受理成功"):Result.error("受理失败");
    }

    @Override
    public Result follow(Follow follow) {
        Integer res = guestMapper.follow(follow);
        return res>0?Result.success("回访登记成功"):Result.error("回访登记失败");
    }

    @Override
    public Result followList() {
        List<Follow> list = guestMapper.followList();
        return Result.success(list);
    }
}
