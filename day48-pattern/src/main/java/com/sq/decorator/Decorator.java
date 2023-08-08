package com.sq.decorator;

public class Decorator extends Info{
    private Info info;

    //传入被装饰对象
    public Decorator(Info info) {
        this.info = info;
    }
    @Override
    public void info() {
        info.info();
    }
}
