package com.bwie.list.mapper;

import com.bwie.common.domain.Car;
import com.bwie.common.domain.Room;
import com.bwie.common.domain.request.CarRequest;
import com.bwie.common.domain.request.RoomRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName
 * @Description 描述
 * @Author XuWen.Luo
 * @Date
 */
@Mapper
public interface CarMapper {

    List<Car> carList(CarRequest carRequest);
}
