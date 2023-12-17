package com.bwie.guest.controller;

import com.bwie.common.domain.Complaint;
import com.bwie.common.domain.Follow;
import com.bwie.common.result.Result;
import com.bwie.guest.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guest")
public class GuestController {


    @Autowired
    private GuestService guestService;

    /**
     * 后台查询投诉列表，可以根据姓名查询
     * @param guestName
     * @return
     */
    @GetMapping("/complaint")
    public Result complaint(@RequestParam("guestName")String guestName){
        return guestService.complaint(guestName);
    }

    /**
     * 员工后台受理投诉
     * @param complaint
     * @return
     */
    @PostMapping("/receive")
    public Result receive(@RequestBody Complaint complaint){
        return guestService.receive(complaint);
    }

    /**
     * 员工对投诉处理后的回访单添加
     * @param follow
     * @return
     */
    @PostMapping("/follow")
    public Result follow(@RequestBody Follow follow){
        return guestService.follow(follow);
    }

    /**
     * 回访记录查询
     * @return
     */
    @GetMapping("/follow")
    public Result followList(){
        return guestService.followList();
    }

    /**
     * 客户新增投诉
     * @param complaint
     * @return
     */
    @PostMapping("/addComplaint")
    public Result addComplaint(@RequestBody Complaint complaint){
        return guestService.addComplaint(complaint);
    }







}
