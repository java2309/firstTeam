import com.sq.pojo.User;
import com.sq.vo.CollectionVo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    public void testUser(){
        //单例和多例
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User)applicationContext.getBean("User");
        User user1 = (User)applicationContext.getBean("User");
        //scope="prototype"多例模式 , 默认为单例
        System.out.println(user == user1);//false
    }
    @Test
    public void testUser1(){
        //生命周期
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User)applicationContext.getBean("User");
        System.out.println(user);
        //关闭
        applicationContext.close();
    }
    @Test
    public void testUser2(){
        //测试注入
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User)applicationContext.getBean("User");
        System.out.println(user);
        //关闭
        applicationContext.close();
    }
    @Test
    public void testCollectionVo(){
        //复杂类型注入
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CollectionVo collectionVo = (CollectionVo)applicationContext.getBean("collectionVo");
        System.out.println(collectionVo);
        //关闭
        applicationContext.close();
    }
}
