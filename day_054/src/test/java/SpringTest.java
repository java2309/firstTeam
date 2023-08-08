import com.qf.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringTest {
    @Test
    public void test () {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取对象
        UserService userService = (UserService)applicationContext.getBean("userService");
        userService.add();
        userService.delete();
        userService.update();
    }
}
