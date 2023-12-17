package com.bwie.list.service.impl;

import com.bwie.common.domain.Car;
import com.bwie.common.domain.Room;
import com.bwie.common.domain.request.CarRequest;
import com.bwie.common.result.Result;
import com.bwie.list.mapper.CarMapper;
import com.bwie.list.service.CarService;
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
public class CarServiceImpl implements CarService {
    @Autowired
    private CarMapper carMapper;

    @Override
    public Result<List<Car>> carList(CarRequest carRequest) {
        List<Car> cars = carMapper.carList(carRequest);
        return Result.success(cars);
    }
}
