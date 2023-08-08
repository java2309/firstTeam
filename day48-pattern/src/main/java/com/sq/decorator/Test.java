package com.sq.decorator;

public class Test {
    public static void main(String[] args) {
        Info personInfo = new PersonInfo();
        //装饰过的singer
        Decorator singer = new Singer(personInfo);
       // singer.info();
        Decorator dancer = new Dancer(singer);
        dancer.info();
    }
}
