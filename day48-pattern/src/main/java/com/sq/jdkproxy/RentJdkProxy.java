package com.sq.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RentJdkProxy implements InvocationHandler {
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    //创建接口的代理对象
    public Rent getRent(){
        return (Rent) Proxy.newProxyInstance(rent.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        publish();
        Object invoke = method.invoke(rent, args);
        return invoke;

    }
    public void publish(){
        System.out.println("发布租房信息");
    }

    public void seeHouse(){
        System.out.println("带租户看房");
    }

}
