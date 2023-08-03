import com.sq.dao.PassengerDao;
import com.sq.pojo.Passenger;
import com.sq.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MybatisTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        PassengerDao mapper = sqlSession.getMapper(PassengerDao.class);
        Passenger byId = mapper.findById(1);
        System.out.println(byId);
        //Passenger(id=1, name=zhansan, sex=f, birthDay=Wed Nov 11 00:00:00 CST 2020, passport=null)
        MybatisUtil.close();
    }
}
