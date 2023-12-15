package com.bwie.user.mapper;

import com.bwie.common.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findname(String userName);

    void upddel(Integer userId);
}
