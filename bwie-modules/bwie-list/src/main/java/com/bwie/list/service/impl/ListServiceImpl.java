package com.bwie.list.service.impl;

import com.bwie.common.domain.Room;
import com.bwie.common.domain.request.RoomRequest;
import com.bwie.common.result.Result;
import com.bwie.list.mapper.ListMapper;
import com.bwie.list.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName
 * @Description 描述
 * @Author XuWen.Luo
 * @Date
 */
@Service
public class ListServiceImpl implements ListService {
    @Autowired
    private ListMapper listMapper;


    @Override
    public Result<List<Room>> roomList(RoomRequest roomRequest) {
        List<Room> rooms = listMapper.roomList(roomRequest);
        return Result.success(rooms);
    }
}
