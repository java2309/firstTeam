import com.qf.controller.AccountController;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config1.xml");
       AccountController accountController = (AccountController)applicationContext.getBean("accountController");
       //这传的实参
       accountController.transfer(2,1,555.0);
    }
}
