package com.bwie.guest.mapper;

import com.bwie.common.domain.Complaint;
import com.bwie.common.domain.Follow;
import com.bwie.common.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface GuestMapper {


    List<Complaint> complaint(@Param("guestName") String guestName);

    Integer addComplaint(Complaint complaint);

    Integer receive(@Param("logon") User logon, @Param("complaint") Complaint complaint);

    Integer follow(Follow follow);

    List<Follow> followList();
}
