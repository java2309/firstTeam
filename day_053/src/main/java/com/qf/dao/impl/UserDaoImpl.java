package com.qf.dao.impl;

import com.qf.dao.UserDao;
import org.springframework.stereotype.Repository;


//@Component//相当于在new UserDaoImpl  spring容器中就有这个对象了
    // value属性：用于指定bean的id。当我们不写时，它的默认值是当前类名，且首字母改小写(我们一般都采用这个)
//专门对于dao层实体类存到spring中，当然第一个也可以
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("来了，昆仑烈火掌");
    }
}
