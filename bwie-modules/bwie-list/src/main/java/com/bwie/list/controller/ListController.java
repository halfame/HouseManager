package com.bwie.list.controller;

import com.bwie.common.domain.Room;
import com.bwie.common.domain.request.RoomRequest;
import com.bwie.common.result.Result;
import com.bwie.list.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName
 * @Description 描述
 * @Author XuWen.Luo
 * @Date
 */
 @RestController
public class ListController {
     @Autowired
    private ListService listService;

     @PostMapping("/roomList")
    public Result<List<Room>> roomList(@RequestBody RoomRequest roomRequest){
         return listService.roomList(roomRequest);
     }



}
