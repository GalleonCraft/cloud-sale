package com.foalnet.cloudsale.controller;

import com.foalnet.cloudsale.service.ManagerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Created by FYQ on 2017/6/28.
 */

@RestController
public class ManagerController {
    @RequestMapping(value="/ledger")
    public void htmlView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.html").forward(request, response);
    }
    private static Logger logger = LoggerFactory.getLogger(ManagerController.class);
    @Autowired
    ManagerService managerService;
//    //测试入口
//    @RequestMapping("/xmjl")
//    public List index(){
//        List<BaseEntity>list=managerService.queryAll();
//        return list;
//    }
}
