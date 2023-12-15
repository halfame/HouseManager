package com.bwie.list.controller;

import com.bwie.common.domain.Car;
import com.bwie.common.domain.request.CarRequest;
import com.bwie.common.result.Result;
import com.bwie.list.service.CarService;
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
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/carList")
    public Result<List<Car>> carList(@RequestBody CarRequest carRequest){
        return carService.carList(carRequest);
    }
}
