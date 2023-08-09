import com.sq.controller.AccountController;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    public void tsetTransfer(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountController accountController = (AccountController)applicationContext.getBean("accountController");
        accountController.transfer(1,2,500.0);
    }
}
