import com.qf.controller.UserController;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringTest {
    @Test
    public void test() {
        //1.加载spring的核心配置,读取配置文件
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.根据需求创建Bean
        UserController userController = (UserController)applicationContext.getBean("userController");
        userController.addControllerUser();
        //3.关闭spring容器
        applicationContext.close();

    }
}
