import com.qf.dao.PassengerDao;
import com.qf.pojo.Passenger;
import com.qf.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MybatisTest {
    @Test
    public void PassengerTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        PassengerDao passengerDao = sqlSession.getMapper(PassengerDao.class);
        List<Passenger> list = passengerDao.findAll();
        for (Passenger passenger : list) {
            System.out.println(passenger);
        }
    }
}
