import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.dao.UserDao;
import com.qf.pojo.User;
import com.qf.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MybatisTest {
    @Test
    public void test(){
        //用咱们封装的来整，方便,先把工具包整一下
        //1.获取SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //2.获取代理对象
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        //3.调方法
        List<User> all = mapper.findAll();
        System.out.println(all);
        //4.释放资源
        MybatisUtil.close();
        //查询不用提交
        //sqlSession.commit();

    }
    @Test
    public void testPage(){
        //分页效果
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        //分页的一个方法,必须在需分页的上方，近挨着
        PageHelper.startPage(1,3);
        List<User> all1 = mapper.findAll1();
        System.out.println(all1);
        //获取userPageInfo，通过它可以获取当前页，总条数什么的
        PageInfo<User> userPageInfo = new PageInfo<>(all1);
        System.out.println(userPageInfo);
        System.out.println("===========");
        List<User> list = userPageInfo.getList();
        for (User user : list) {
            System.out.println(user);
        }
        System.out.println("==============");
        System.out.println("当前页:" + userPageInfo.getPageNum());
        System.out.println("每页显示的条数:" + userPageInfo.getPageSize());
        System.out.println("总条数:" + userPageInfo.getTotal());
        System.out.println("总页数:" + userPageInfo.getPages());
        //释放资源
        MybatisUtil.close();
    }

}
