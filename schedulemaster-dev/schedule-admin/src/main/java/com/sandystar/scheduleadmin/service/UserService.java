package com.sandystar.scheduleadmin.service;


import com.sandystar.scheduleadmin.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void getUserPwd(){

    }
}
