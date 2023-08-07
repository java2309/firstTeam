import com.sq.pojo.Car;
import com.sq.pojo.User;
import lombok.Data;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void testCar(){
       ApplicationContext  applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user1 = (User)applicationContext.getBean("user1");
        User user2 = (User)applicationContext.getBean("user2");
        System.out.println(user1);
        System.out.println(user2);
    }
}
