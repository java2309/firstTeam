import com.qf.dao.PassengerDao;
import com.qf.pojo.Passenger;
import com.qf.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MybatisTest {
    @Test
    public void test(){
        //1.获取sqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //2.获取代理人
        PassengerDao mapper = sqlSession.getMapper(PassengerDao.class);
        //3.调方法，打印
        Passenger passenger = mapper.findById(1);
        System.out.println(passenger);
        //更加清楚的打印出我们想要的资源
        System.out.println(passenger.getPassport().getNationality());
        //4.释放资源
        MybatisUtil.close();

    }
}
