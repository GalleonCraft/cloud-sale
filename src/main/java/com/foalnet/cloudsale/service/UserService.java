package com.foalnet.cloudsale.service;

import com.foalnet.cloudsale.entity.User;
import com.foalnet.cloudsale.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by FYQ on 2017/6/29.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 查询账簿
     *
     * @throws Exception
     */
    @Transactional
    public  List<User> queryAll(){
        PageHelper.startPage(1, 10);
        PageHelper.orderBy("id");
        List<User> list = userMapper.selectAll();
        return list;
    }

    @Transactional
    public  User queryByUsername(String username){
        User user = userMapper.queryByUsername(username);
        return user;
    }
}
