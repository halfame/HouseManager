package com.bwie.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class User {
    private Integer userId;
    private String userName;
    private String userNick;
    private String userEmail;
    private String userTel;
    private Integer userStstus;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date userTime;
    private String userPwd;
    private Integer roleId;













}
