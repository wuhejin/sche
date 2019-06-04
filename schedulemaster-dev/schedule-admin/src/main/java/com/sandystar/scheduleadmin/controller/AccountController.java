package com.sandystar.scheduleadmin.controller;


import com.sandystar.scheduleadmin.result.RestResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {


    @RequestMapping("/resetPwd")
    public RestResult resetPwd(){


        return new RestResult();
    }

}
