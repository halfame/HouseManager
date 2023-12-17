package com.bwie.system.service;

import com.bwie.common.domain.Catalogue;
import com.bwie.common.result.Result;

public interface SystemService {
    Result catalogue(Integer pid);

    Result add(Catalogue catalogue);
}
