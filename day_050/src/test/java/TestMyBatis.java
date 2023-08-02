import com.qf.dao.UserDao;
import com.qf.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.apache.ibatis.io.Resources;

import java.io.InputStream;
import java.util.List;

public class TestMyBatis {
    @Test
    public void testSelect() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder Builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = Builder.build(in);
        SqlSession sqlSession = factory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.findAllUser();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
        in.close();

    }
}







// //1.读取配置文件，导的apache的包
//        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
//        //2.创建SqlSessionFactory工厂
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory factory = builder.build(in);
//        //3.使用工厂生产sqlSession
//        SqlSession sqlSession = factory.openSession();
//        //4.通过sqlSession创建Dao接口的代理对象
//        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        //5.使用代理对象执行方法，代理就是好
//        List<User> users = userDao.findAllUser();
//        for (User user : users) {
//            System.out.println(user);
//        }
//        //6.释放资源
//        sqlSession.close();
//        in.close();