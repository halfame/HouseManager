package com.bwie.system.controller;

import com.bwie.common.domain.Catalogue;
import com.bwie.common.result.Result;
import com.bwie.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system")
public class SystemComtroller {

    @Autowired
    private SystemService systemService;

    /**
     * 查询菜单目录
     * 1、查询所有一级目录 pid 为0
     * 2、查询点击目录的下级目录 pid为点击目录的id
     *  @return
     */
    @GetMapping("/catalogue")
    public Result catalogue(@RequestParam Integer pid){
        return systemService.catalogue(pid);
    }

    /**
     * 新增目录功能
     * @param catalogue
     * @return
     */
    @PostMapping("/addCatalogue")
    public Result add(@RequestBody Catalogue catalogue){
        return systemService.add(catalogue);
    }


}
