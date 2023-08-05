import com.sq.dao.CarDao;
import com.sq.dao.StudentDao;
import com.sq.pojo.Car;
import com.sq.pojo.Student;
import com.sq.pojo.Subject;
import com.sq.util.MybatisUtil;
import com.sq.vo.CarVo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MybatisTest {
    @Test
    public void testSelect(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Student student = mapper.findById(1);
        System.out.println(student);
        List<Subject> subject = student.getSubject();
        for (Subject subject1 : subject) {
            System.out.println(subject1);
        }
        //Student(id=1, name=jack, sex=null, subject=[Subject(id=1001, name=java, grade=1, student=null),
        //Subject(id=1002, name=python, grade=2, student=null)])
        //Subject(id=1001, name=java, grade=1, student=null)
        //Subject(id=1002, name=python, grade=2, student=null)
        MybatisUtil.close();
    }
    @Test
        public void testSelectAll() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        CarDao mapper = sqlSession.getMapper(CarDao.class);
        List<Car> all = mapper.findAll();
        for (Car car : all) {
            System.out.println(all);
        }
        MybatisUtil.close();
    }
    @Test
    public void findById() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        CarDao mapper = sqlSession.getMapper(CarDao.class);
        Car byId = mapper.findById(1);
        System.out.println(byId);
        //Car(id=1, name=迈腾, brand=大众, price=200000.0, color=黑色, num=5000)
        MybatisUtil.close();
    }
    @Test
    public void findCar() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        CarDao mapper = sqlSession.getMapper(CarDao.class);
        CarVo carVo = new CarVo();
        carVo.setQueryName("卡宴");
        List<Car> car = mapper.findCar(carVo);
        for (Car car1 : car) {
            System.out.println(car1);
        }
        //Car(id=3, name=卡宴, brand=保时捷, price=700000.0, color=白色, num=2000)

        MybatisUtil.close();
    }
    @Test
    public void findCar1() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        CarDao mapper = sqlSession.getMapper(CarDao.class);
        CarVo carVo = new CarVo();
        carVo.setQueryBrand("宝马");
        carVo.setQueryColor("黑色");
        List<Car> car = mapper.findCar(carVo);
        //Car(id=5, name=宝马X5, brand=宝马, price=500000.0, color=黑色, num=2000)
        System.out.println(car);
        MybatisUtil.close();
    }
    @Test
    public void update() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        CarDao mapper = sqlSession.getMapper(CarDao.class);
        Car car = new Car();
        car.setName("xixi");
        car.setColor("彩色");
        car.setBrand("宝马");
        car.setId(6);
        mapper.update(car);
        MybatisUtil.commit();
        MybatisUtil.close();
    }
    @Test
    public void update1() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        CarDao mapper = sqlSession.getMapper(CarDao.class);
        Car car = new Car();
        car.setName("金木");
        car.setColor("彩色");
        car.setBrand("宝马");
        car.setId(6);
        mapper.update1(car);
        MybatisUtil.commit();
        MybatisUtil.close();
    }
    @Test
    public void deleteByIds() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        CarDao mapper = sqlSession.getMapper(CarDao.class);
//        HashSet<Integer> set = new HashSet<>();
//        set.add(1);
//        set.add(2);
//        set.add(3);
//        mapper.deleteByIds(set);

        //Integer[] ig = {4,5};
        List<Integer> list = new ArrayList<>();
        list.add(6);
        mapper.deleteByIds(list);
        MybatisUtil.commit();
        MybatisUtil.close();
    }
}
