package com.bwie.common.domain;

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
public class Room {
    /**
     * 编号
     */
    private Integer roomId;
    /**
     * 房间编号
     */
    private Integer roomCrad;
    /**
     * 客户姓名
     */
    private Integer clientId;
    /**
     * 电话
     */
    private String clientPhone;
    /**
     * 证件类型
     */
    private Integer typeIdcard;
    /**
     * 证件号码
     */
    private Integer idNumber;
    /**
     * 楼号
     */
    private Integer floorId;
    /**
     * 楼层
     */
    private Integer buildId;
    /**
     * 建筑面积
     */
    private Integer createNum;
    /**
     * 户型
     */
    private String houseType;
    /**
     * 装修
     */
    private String fitment;
}
