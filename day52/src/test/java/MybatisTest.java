import com.qf.dao.StudentDao;
import com.qf.dao.SubjectDao;
import com.qf.pojo.Student;
import com.qf.pojo.Subject;
import com.qf.utils.MybatisUtil;
import org.junit.Test;

import java.util.List;

public class MybatisTest {
    @Test
    public void studentTest(){
        StudentDao mapper = MybatisUtil.getSqlSession().getMapper(StudentDao.class);
        Student student = mapper.findAllById(1);
        System.out.println(student);
        List<Subject> subjectList = student.getSubjectList();
        for (Subject subject : subjectList) {
            System.out.println(subject);
        }
    }
    @Test
    public void subjectTest(){
        SubjectDao mapper = MybatisUtil.getSqlSession().getMapper(SubjectDao.class);
        Subject subject = mapper.findAllById(1001);
        System.out.println(subject);
        List<Student> studentList = subject.getStudentList();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
