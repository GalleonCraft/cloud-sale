package com.foalnet.cloudsale.mapper;

import com.foalnet.cloudsale.entity.BaseEntity;
import com.foalnet.cloudsale.util.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface HomeMapper extends BaseMapper<BaseEntity> {

    @Select("SELECT * FROM dbo.aaaa ")
    List<Map<String,Object>> getAll();

}
