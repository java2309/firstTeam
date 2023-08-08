package com.sq.staticproxy;
//代理对象
public class OwenrProxy implements Rent{
   private Owner owner;

    public OwenrProxy(Owner owner) {
        this.owner = owner;
    }

    @Override
    public void rent() {
        publish();
        //其实还是房东在租房子
        owner.rent();
        seeHoser();
    }
    public void seeHoser(){
        System.out.println("带人看房");
    }
    public void publish(){
        System.out.println("发布出租信息");
    }
}
