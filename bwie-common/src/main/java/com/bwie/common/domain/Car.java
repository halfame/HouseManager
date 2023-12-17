package com.bwie.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName
 * @Description 描述
 * @Author XuWen.Luo
 * @Date
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private Integer carId;
    private String carCard;
    private Integer clientId;
    private String clientPhone;
    private Integer carType;
    private String carStatus;
    private String roomCard;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endTime;
}
