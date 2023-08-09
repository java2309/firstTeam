package com.sq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")//一级请求路径
public class UserController {

    @RequestMapping("/login")//二级请求路径
    public ModelAndView login(){

        System.out.println("login..");

        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //保存数据
        modelAndView.addObject("usrename","张三");
        //设置跳转的路径
        //modelAndView.setViewName("/jsp/show.jsp");
        //视图解析器
        modelAndView.setViewName("/show");

        return modelAndView;
    }
}
