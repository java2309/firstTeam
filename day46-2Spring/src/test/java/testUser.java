import com.sq.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testUser {
    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User)applicationContext.getBean("user");
        System.out.println(user);
        //初始化方法
        //User(id=1, name=小爱好, password=12311, car=Car(cid=21, cname=水啊))
        //销毁方法
        applicationContext.close();
    }
}
