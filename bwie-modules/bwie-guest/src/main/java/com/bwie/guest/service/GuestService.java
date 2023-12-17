package com.bwie.guest.service;

import com.bwie.common.domain.Complaint;
import com.bwie.common.domain.Follow;
import com.bwie.common.result.Result;
import org.springframework.web.bind.annotation.RequestBody;

public interface GuestService {
    Result complaint(String guestName);

    Result addComplaint(Complaint complaint);

    Result receive(@RequestBody Complaint complaint);

    Result follow(Follow follow);

    Result followList();
}
