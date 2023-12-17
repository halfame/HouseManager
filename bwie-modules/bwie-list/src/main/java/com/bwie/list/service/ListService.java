package com.bwie.list.service;

import com.bwie.common.domain.Room;
import com.bwie.common.domain.request.RoomRequest;
import com.bwie.common.result.Result;

import java.util.List;

/**
 * @ClassName
 * @Description 描述
 * @Author XuWen.Luo
 * @Date
 */

public interface ListService {
    Result<List<Room>> roomList(RoomRequest roomRequest);
}
