package com.foalnet.cloudsale.controller;

import com.foalnet.cloudsale.entity.User;
import com.foalnet.cloudsale.jwt.JwtToken;
import com.foalnet.cloudsale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by FYQ on 2018/3/6.
 */

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/lgoin")
    public Map<String,Object> getAccessToken(String username, String password) throws Exception {
        userService.queryAll();
        User user = userService.queryByUsername(username);
        Map<String,Object> data = new HashMap<>();
        if(user.getPassword().equals(password)){
            JwtToken.createToken(user);
            data.put("access_token",JwtToken.createToken(user));
            data.put("message","登陆成功！");
            data.put("flag",Boolean.TRUE);
        }else{
            data.put("access_token","");
            data.put("message","用户名或密码错误！");
            data.put("flag",Boolean.FALSE);
        }
        return data;
    }
}
