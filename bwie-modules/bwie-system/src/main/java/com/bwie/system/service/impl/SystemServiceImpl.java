package com.bwie.system.service.impl;

import com.bwie.common.domain.Catalogue;
import com.bwie.common.result.Result;
import com.bwie.system.mapper.SystemMapper;
import com.bwie.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private SystemMapper systemMapper;

    @Override
    public Result catalogue(Integer pid) {
        List<Catalogue> list = systemMapper.catalogue(pid);
        return Result.success(list);
    }

    @Override
    public Result add(Catalogue catalogue) {
        Integer res = systemMapper.add(catalogue);
        return res>0?Result.success("添加目录成功"):Result.error("添加目录失败");
    }
}
