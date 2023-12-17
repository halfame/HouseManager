package com.bwie.system.mapper;

import com.bwie.common.domain.Catalogue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SystemMapper {


    List<Catalogue> catalogue(@Param("pid") int pid);

    Integer add(Catalogue catalogue);


}
