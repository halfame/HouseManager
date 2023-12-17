package com.bwie.common.domain;

import lombok.Data;

@Data
public class Power {
    private Integer powId;
    private String powName;
    private String powSrc;
    private String powType;
    private Integer powParent;
    private Integer powSort;
}
