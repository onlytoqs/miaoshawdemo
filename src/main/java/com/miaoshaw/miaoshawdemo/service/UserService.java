package com.miaoshaw.miaoshawdemo.service;

import com.miaoshaw.miaoshawdemo.dao.UserDao;
import com.miaoshaw.miaoshawdemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;
    public List<User> getById(int id){
        return userDao.getById(id);
    }
}
