package com.bwie.common.domain.request;

import lombok.Data;

@Data
public class LoginRequest {
    private Integer userId;
    private String userName;
    private String userPwd;
    private String userCode;
}
