package com.ken.wms.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Class: TestController
 * Description:
 * Author: Alan Min
 * Createtime: 2019/1/10
 */
@Controller
public class TestController {

    @PostMapping("/doTest")
    public String test(@RequestParam("uname") String uname, @RequestParam("pwd")String pwd)
    {
        System.out.println(uname);
        System.out.println(pwd);
        return "mainPage";
    }

    @GetMapping("/test")
    public String test()
    {
        return "Test";
    }

}
