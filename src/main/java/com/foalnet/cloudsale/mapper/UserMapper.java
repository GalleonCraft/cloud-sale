package com.foalnet.cloudsale.mapper;

import com.foalnet.cloudsale.entity.User;
import com.foalnet.cloudsale.util.BaseMapper;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT * FROM dbo.t_user " +
            "WHERE username=#{username} ")
    @Results(value = {
            @Result(property = "role", column = "role_id", one = @One(select ="com.foalnet.cloudsale.mapper.RoleMapper.selectByPrimaryKey")),
    })
    User queryByUsername(@Param("username")String username);

}
