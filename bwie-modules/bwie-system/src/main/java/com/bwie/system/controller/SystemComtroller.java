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
     * @return
     */
    @GetMapping("/catalogue")
    public Result catalogue(){
        return systemService.catalogue();
    }

    @PostMapping("/addCatalogue")
    public Result add(@RequestBody Catalogue catalogue){
        return systemService.add(catalogue);
    }


}
