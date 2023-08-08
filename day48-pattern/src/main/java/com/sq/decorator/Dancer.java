package com.sq.decorator;

public class Dancer extends Decorator{
    public Dancer(Info info) {
        super(info);
    }
    public void dancing(){
        System.out.println("跳舞");
    }

    @Override
    public void info() {
        super.info();
        dancing();
    }
}
