package com.sq.jdkproxy;

import com.sq.staticproxy.Owner;

public class Test {
    public static void main(String[] args) {
        RentJdkProxy rentJdkProxy = new RentJdkProxy();
        rentJdkProxy.setRent(new Owenr());
        //获取代理对象
        Rent rent = rentJdkProxy.getRent();
        rent.rent();
    }
}
