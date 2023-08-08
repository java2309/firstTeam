import com.github.pagehelper.PageInfo;
import com.sq.controller.UserController;
import com.sq.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringTest {
    @Test
    public void test_findAll(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController = (UserController)applicationContext.getBean("userController");
        PageInfo<User> byPage = userController.findByPage(1, 2);
        System.out.println(byPage.getList());
        //[User(id=1, name=jack, password=123), User(id=2, name=tom, password=456)]
        applicationContext.close();
    }
}
