package com.sq.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Data
public class User {
    @Value("1")
    private Integer id;
    @Value("小爱好")
    private String name;
    @Value("12311")
    private String password;
    @Autowired//自动按照类型注入
    private Car car;

    @PostConstruct//用于指定初始化方法 /相当与 bean中的 init-method 属性
    public void init(){
        System.out.println("初始化方法");
    }
@PreDestroy//用于指定销毁方法//相当与 bean中的 init-method 属性
    public void destroy(){
        System.out.println("销毁方法");
    }
}
