package com.sq.staticproxy;

public class Owner implements Rent{
    @Override
    public void rent() {
        System.out.println("出租房屋");
    }
}
