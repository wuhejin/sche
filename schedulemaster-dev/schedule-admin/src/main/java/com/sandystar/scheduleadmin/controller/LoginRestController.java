package com.sandystar.scheduleadmin.controller;

import com.sandystar.scheduleadmin.result.RestResult;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginRestController {

//    @RequestMapping("/")
//    public ModelAndView defaultPage(){
//
//        return new ModelAndView("login");
//    }
//
//    @PostMapping("/login")
//    public ModelAndView login(String username, String password){
//
//
//        if("admin".equals(username) && "123".equals(password)){
//            return new ModelAndView("main");
//        }
//        return new ModelAndView("login");
//    }

    @PostMapping("/loginRest")
    public RestResult loginRest(String username, String password) {

        if("admin".equals(username) && "123".equals(password)){
            Map<String,String> map = new HashMap<>();
            map.put("userName",username);
            map.put("token", DigestUtils.md5DigestAsHex((username+password).getBytes()));
            return new RestResult(map);
        }
        return RestResult.FAILED;
    }

}
