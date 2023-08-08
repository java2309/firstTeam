

import com.github.pagehelper.PageInfo;
import com.qf.controller.UserController;
import com.qf.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringTest {

    @Test
    public void test_findAll(){

        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-config.xml");

        UserController userController =
                (UserController)applicationContext.getBean("userController");

        List<User> list = userController.findAll();

        System.out.println(list);
        PageInfo<User> userPageInfo = userController.findByPage(2, 3);
        System.out.println(userPageInfo.getList());
    }
}
