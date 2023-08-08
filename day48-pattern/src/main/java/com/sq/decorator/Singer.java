package com.sq.decorator;

public class Singer extends Decorator{
    public Singer (Info info){
        super(info);//调用父类有参构造
    }
    public void sing(){
        System.out.println("来首翠花..");
    }
    @Override
    public void info() {
        super.info();
        sing();
    }
}
