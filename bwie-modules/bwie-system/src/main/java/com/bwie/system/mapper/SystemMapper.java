package com.bwie.system.mapper;

import com.bwie.common.domain.Catalogue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SystemMapper {


    List<Catalogue> catalogue(int i);

    Integer add(Catalogue catalogue);


}
