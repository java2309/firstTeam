package com.sq.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component//用于把当前类对象存入spring容器中
@Data
public class Car {
    @Value("21")//用于注入基本类型和String类型的数据
    private Integer cid;
    @Value("水啊")
    private String cname;
}
