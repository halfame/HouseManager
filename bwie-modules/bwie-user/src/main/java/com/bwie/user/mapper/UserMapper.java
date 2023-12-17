package com.bwie.user.mapper;

import com.bwie.common.domain.Role;
import com.bwie.common.domain.User;
import com.bwie.common.domain.request.RoleShowRequest;
import com.bwie.common.domain.request.RoleUpdRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface UserMapper {
    User findname(String userName);



    List<Role> showr(RoleShowRequest roleShowRequest);


    Integer updu(Integer[] roleIds);

    Integer delr(Integer[] roleIds);

    void addr(Role role);

    void updr(RoleUpdRequest role);
}
