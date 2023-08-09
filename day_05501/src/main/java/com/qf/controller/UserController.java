package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
//@RequestMapping如果写在类上面表示URL
// 访问当前类下面所有的方法的时候都要带/user,一级请求路径
@RequestMapping(value = "/user")
public class UserController {
    @RequestMapping("/login")//二级请求路径
    public ModelAndView test(){
        System.out.println("昆仑烈火张");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username","楚枫");
        //设置返回的视图
        //modelAndView.setViewName("/jsp/show.jsp");
        modelAndView.setViewName("/show");//使用了视图解析器
        return modelAndView;
    }

}
