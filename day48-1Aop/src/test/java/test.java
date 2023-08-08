import com.sq.service.UserService;
import com.sq.service.impl.UserServiceImpl;
import com.sq.service1.UserService1;
import com.sq.service1.impl.UserServiceImpl1;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void testAop(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService)applicationContext.getBean("userService");
        userService.add();
        userService.delete();
        userService.update();
    }
    @Test
    public void testUserService1(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        UserServiceImpl1 userServiceImpl1 = (UserServiceImpl1)applicationContext.getBean("userServiceImpl1");
        userServiceImpl1.add();
        userServiceImpl1.delete();
        userServiceImpl1.update();
    }
}
