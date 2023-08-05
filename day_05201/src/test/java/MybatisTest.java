import com.qf.dao.CarDao;
import com.qf.dao.StudentDao;
import com.qf.dao.SubjectDao;
import com.qf.pojo.Car;
import com.qf.pojo.Student;
import com.qf.pojo.Subject;
import com.qf.utils.MybatisUtil;
import com.qf.vo.CarVo;
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
        //获取学科，是个集合
        List<Subject> subjectList = student.getSubjectList();
        //var的时候导错包，不知道为啥
        for (Subject subject : subjectList) {
                System.out.println(subject);
            }
        MybatisUtil.close();
    }
    @Test
    public void testSelect1(){
        //通过学科看学生
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        SubjectDao mapper = sqlSession.getMapper(SubjectDao.class);
        Subject subject = mapper.findById1(1);
        List<Student> studentList = subject.getStudentList();
        for (Student student : studentList) {
            System.out.println(student);
        }
        MybatisUtil.close();
    }
    @Test
    public void testSelectAll(){
        //获取所有car的信息
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        CarDao mapper = sqlSession.getMapper(CarDao.class);
        List<Car> cars = mapper.findAll();
        System.out.println(cars);
        MybatisUtil.close();
    }
    @Test
    public void testSelectAll1 () {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        CarDao carDao = sqlSession.getMapper(CarDao.class);

        //用到了carVo这个类，先new出来对其赋值
        //根据条件查询，用到了sql语句
//        CarVo carVo = new CarVo();
//        carVo.setQueryBrand("大众");
//        carVo.setQueryName("迈腾");
//        List<Car> car = carDao.findCar(carVo);
//        System.out.println(car);


        //修改，需要提交，用到了动态sql
        //修改吗，我们要为其赋值，所以要new这个对象
//        Car car = new Car();
//        car.setColor("骚粉");
//        car.setId(3);
//        carDao.update(car);
//        MybatisUtil.commit();

         //批量删除有关的，数组类型的
        //在映射的CarMapper.xml中的批量删除中有collection时，其对应的方法也要有@Param()，不然找不到，删不掉
//        Integer[] ids = {1,2};
//        carDao.deleteByIds(ids);
//        MybatisUtil.commit();
        //List集合的
        List<Integer> list  = new ArrayList<>();
        list.add(4);
        list.add(5);
        carDao.deleteByIds(list);
        MybatisUtil.commit();
        //set集合的  可以
//          Set<Integer> set = new HashSet<>();
//          set.add(6);
//         carDao.deleteByIds(set);
//         MybatisUtil.commit();
//        Car car1 = carDao.findById(7);
//        sqlSession.clearCache();
//        Car car2 = carDao.findById(7);
//        System.out.println(car1 == car2);
//        MybatisUtil.commit();
        MybatisUtil.close();
    }
}
