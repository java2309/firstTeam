package com.sq.decorator;

public class PersonInfo extends Info{
    @Override
    public void info() {
        System.out.println("自我介绍...");
    }
}
