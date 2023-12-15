package com.bwie.list.mapper;

import com.bwie.common.domain.Room;
import com.bwie.common.domain.request.RoomRequest;
import com.bwie.common.result.Result;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName
 * @Description 描述
 * @Author XuWen.Luo
 * @Date
 */
@Mapper
public interface ListMapper {

    List<Room> roomList(RoomRequest roomRequest);
}
