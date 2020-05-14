package com.miaoshaw.miaoshawdemo.controller;


import com.miaoshaw.miaoshawdemo.Result.Result;
import com.miaoshaw.miaoshawdemo.pojo.User;
import com.miaoshaw.miaoshawdemo.redis.KeyPrefix;
import com.miaoshaw.miaoshawdemo.redis.RedisService;
import com.miaoshaw.miaoshawdemo.redis.UserKey;
import com.miaoshaw.miaoshawdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
@RequestMapping("/demo")
public class SampleController {

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name","zhangsan");
        return "hello";
    }
    @RequestMapping("/get")
    @ResponseBody
    public List <User> getById(){
        return userService.getById(1);
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<User> redisGet(){
        User user = redisService.get(UserKey.getById, ""+1, User.class);
        return Result.success(user);
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<Boolean> redisSet(){
        User user = new User();
        user.setId(1);
        user.setName("1111");
        redisService.set(UserKey.getById, ""+1, user);
        return Result.success(true);
    }
}
