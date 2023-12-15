package com.bwie.common.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName
 * @Description 描述
 * @Author XuWen.Luo
 * @Date
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarRequest {
    private String clientName;
    private Integer pageNum = 1;
    private Integer pageSize = 3;
}
