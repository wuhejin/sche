package com.sandystar.scheduleadmin.controller;

import com.sandystar.scheduleadmin.po.Menu;
import com.sandystar.scheduleadmin.result.RestResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.expression.Lists;

import java.util.*;

@RestController
@RequestMapping("/mainPage")
public class MainPageController {

    @RequestMapping("/menuList")
    public RestResult getMenuList(){

        List<Menu> menuListRes = new ArrayList<>();

//        Menu [] menuList = {new Menu(1,"系统总览", "fa fa fa-institution", "/child/dashboard.html", )};
        menuListRes.add(new Menu(1,"系统总览", "fa fa fa-chart", "/child/dashboard.html", new Menu[]{}));
        menuListRes.add(new Menu(2,"实时进度", "fa fa fa-user-circle-o", "/child/real_progress.html", new Menu[]{}));
        menuListRes.add(new Menu(3,"列车信息", "fa fa fa-institution", "/child/train_info.html", new Menu[]{}));

        Menu[] maintainChild = new Menu[] {

                new Menu(11,"检修分配", "fa fa fa-chart", "/child/maintain/disaptch.html", new Menu[]{}),
                new Menu(12,"检修项目", "fa fa fa-chart", "/child/maintain/item.html", new Menu[]{}),
                new Menu(13,"检修工具", "fa fa fa-chart", "/child/maintain/tool.html", new Menu[]{})

        };

        menuListRes.add(new Menu(4,"检修管理", "fa fa fa-gear", "null", maintainChild));
        menuListRes.add(new Menu(5,"人员管理", "fa fa fa-user", "/child/employee.html", new Menu[]{}));

        return new RestResult(menuListRes);
    }

}
