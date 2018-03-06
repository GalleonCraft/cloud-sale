package com.foalnet.cloudsale.mapper;


import com.foalnet.cloudsale.entity.Role;
import com.foalnet.cloudsale.util.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {

}
