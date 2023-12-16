package com.bwie.user.mapper;

import com.bwie.common.domain.Role;
import com.bwie.common.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User findname(String userName);

    void upddel(Integer userId);

    List<Role> showr(String roleName);
}
