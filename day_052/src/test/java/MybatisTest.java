import com.qf.dao.DepartmentDao;
import com.qf.dao.EmployeeDao;
import com.qf.pojo.Department;
import com.qf.pojo.Employee;
import com.qf.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MybatisTest {
    @Test
    public void testSelect(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //传参是这个接口的字节码文件
        DepartmentDao mapper = sqlSession.getMapper(DepartmentDao.class);
        Department department = mapper.findById(1);
        System.out.println(department.getName());
        List<Employee> emps = department.getEmps();
        for (Employee emp : emps) {
            System.out.println(emp.getName());
        }
        MybatisUtil.close();
    }
    @Test
    public void testSelect1(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
        Employee employee = mapper.findById1(1);
        System.out.println(employee.getName());
        System.out.println(employee.getDepartment());
        MybatisUtil.close();

    }
}
