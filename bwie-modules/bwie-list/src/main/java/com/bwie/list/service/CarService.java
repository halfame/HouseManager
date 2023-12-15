package com.bwie.list.service;

import com.bwie.common.domain.Car;
import com.bwie.common.domain.request.CarRequest;
import com.bwie.common.result.Result;

import java.util.List;

/**
 * @ClassName
 * @Description 描述
 * @Author XuWen.Luo
 * @Date
 */

public interface CarService {
    Result<List<Car>> carList(CarRequest carRequest);
}
