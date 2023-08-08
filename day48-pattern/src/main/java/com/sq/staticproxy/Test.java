package com.sq.staticproxy;

public class Test {
    public static void main(String[] args) {
        Owner owner = new Owner();
        OwenrProxy owenrProxy = new OwenrProxy(owner);
        owenrProxy.rent();

    }
}
