
import com.sq.dao.DepartmentDao;
import com.sq.dao.EmployeeDao;
import com.sq.pojo.Department;
import com.sq.pojo.Employee;
import com.sq.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MybatisTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        DepartmentDao mapper = sqlSession.getMapper(DepartmentDao.class);
        Department byId = mapper.findById(1);
        System.out.println(byId);
        //Department(id=1, name=教学部, location=北京, employee=[Employee(id=1, name=jack, salary=1000.5,
        // departments=null), Employee(id=2, name=rose, salary=2000.5, departments=null)])
        List<Employee> employee = byId.getEmployee();
        for (Employee emp : employee) {
            System.out.println(emp);
        }
        //Employee(id=1, name=jack, salary=1000.5, departments=null)
        //Employee(id=2, name=rose, salary=2000.5, departments=null)
        MybatisUtil.close();
    }
    @Test
    public void testEmp(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
        Employee employee = mapper.findById1(1);
        System.out.println(employee);
        MybatisUtil.close();
    }
}
