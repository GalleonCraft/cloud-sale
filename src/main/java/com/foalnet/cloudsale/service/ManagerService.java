package com.foalnet.cloudsale.service;

import com.foalnet.cloudsale.entity.BaseEntity;
import com.foalnet.cloudsale.mapper.HomeMapper;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by FYQ on 2017/6/29.
 */
@Service
public class ManagerService {
    private static Logger logger = LoggerFactory.getLogger(ManagerService.class);
    @Autowired
    private HomeMapper homeMapper;
    /**
     * 查询账簿
     *
     * @throws Exception
     */
    @Transactional
    public  List<BaseEntity> queryAll(){
        PageHelper.startPage(1, 10);
        PageHelper.orderBy("id");
//        Example example = new Example(BaseEntity.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andLike("id", "%"+1000+"%");

        List<BaseEntity> list = homeMapper.selectAll();
        return list;
    }


}
