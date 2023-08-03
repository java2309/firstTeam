import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sq.dao.UserDao;
import com.sq.pojo.User;
import com.sq.util.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.ognl.security.UserMethod;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    @Test
    public void testFindAll() throws IOException {
        //1.读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        //5.使用代理对象执行方法
        List<User> allUser = mapper.findAllUser();
        for (User user : allUser) {
            System.out.println(user);
        }
        //增
        //mapper.addUser();
        //提交
        sqlSession.commit();
        //7.释放资源
        sqlSession.close();
        resourceAsStream.close();
    }
    @Test
    public void findById() throws IOException {
        //1.读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        //5.使用代理对象执行方法
        User byId = mapper.findById(2);
        System.out.println(byId);
        //User(id=2, name=tom, password=456)
        //提交
        sqlSession.commit();
        //7.释放资源
        sqlSession.close();
        resourceAsStream.close();
    }
    @Test
    public void addUser() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setName("背包");
        user.setPassword("12345");
        mapper.addUser(user);
        System.out.println("添加用户的id为：" +user.getId());
        sqlSession.commit();
        sqlSession.close();
        resourceAsStream.close();
    }
    @Test
    public void findByName1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> byName1 = mapper.findByName1("%灯火%");
        System.out.println(byName1);
        sqlSession.commit();
        sqlSession.close();
        resourceAsStream.close();
    }
    @Test
    public void findByName2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> byName1 = mapper.findByName1("灯火");
        System.out.println(byName1);
        sqlSession.commit();
        sqlSession.close();
        resourceAsStream.close();
    }
    @Test
    public void findByName3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> byName1 = mapper.findByName1("灯火");
        System.out.println(byName1);
        sqlSession.commit();
        sqlSession.close();
        resourceAsStream.close();
    }
    @Test
    public void deleteUserById() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.deleteUserById(4);
        sqlSession.commit();
        sqlSession.close();
        resourceAsStream.close();
    }
    @Test
    public void updateUser() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User byId = mapper.findById(1);
        byId.setName("孩子");
        mapper.updateUser(byId);
        sqlSession.commit();
        sqlSession.close();
        resourceAsStream.close();
    }
    @Test
    public void getTotalCount() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        Integer totalCount = mapper.getTotalCount();
        System.out.println(totalCount);
        sqlSession.commit();
        sqlSession.close();
        resourceAsStream.close();
    }
    @Test
    public void findPageData() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> pageData = mapper.findPageData(0, 3);
        System.out.println(pageData);
        //[User(id=1, name=孩子, password=123), User(id=2, name=tom, password=456), User(id=3, name=rose, password=789)]
        List<User> pageData1 = mapper.findPageData(2, 4);
        System.out.println(pageData1);
        //[User(id=3, name=rose, password=789), User(id=5, name=灯火, password=12345),
        // User(id=6, name=咖啡, password=12345), User(id=7, name=梦中的堡垒, password=12345)]
        sqlSession.commit();
        sqlSession.close();
        resourceAsStream.close();
    }
    //使用工具类测试
    @Test
    public void testMybatisUtilFindAll(){
        //获取SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //获取Mapper接口的代理对象
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        //测试方法
        List<User> userList = mapper.findAllUser();
        System.out.println(userList);
        //释放资源
        MybatisUtil.close();
    }
//使用工具类测试分页插件查询
    @Test
    public void testPage(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        PageHelper.startPage(1,3);
        List<User> userList = mapper.findAllUser();
        System.out.println(userList);
        //Page{count=true, pageNum=1, pageSize=3, startRow=0, endRow=3, total=8, pages=3, reasonable=true,
        // pageSizeZero=false}[User(id=1, name=孩子, password=123), User(id=2, name=tom, password=456), User(id=3, name=rose, password=789)]
        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        System.out.println(userPageInfo);
        //PageInfo{pageNum=1, pageSize=3, size=3, startRow=1, endRow=3, total=8, pages=3,
        // list=Page{count=true, pageNum=1, pageSize=3, startRow=0, endRow=3, total=8, pages=3, reasonable=true, pageSizeZero=false}[User(id=1, name=孩子, password=123), User(id=2, name=tom, password=456), User(id=3, name=rose, password=789)], prePage=0, nextPage=2, isFirstPage=true, isLastPage=false, hasPreviousPage=false, hasNextPage=true, navigatePages=8, navigateFirstPage=1, navigateLastPage=3, navigatepageNums=[1, 2, 3]}

        List<User> list = userPageInfo.getList();
        for (User user : list) {
            System.out.println(user);
        }
        //User(id=1, name=孩子, password=123)
        //User(id=2, name=tom, password=456)
        //User(id=3, name=rose, password=789)

        System.out.println("===========================");
        System.out.println("当前页"+userPageInfo.getPageNum());
        System.out.println("每页显示数据条数"+userPageInfo.getPageSize());
        System.out.println("总条数"+userPageInfo.getTotal());
        System.out.println("总页数"+userPageInfo.getPages());
        //当前页1
        //每页显示数据条数3
        //总条数8
        //总页数3
        MybatisUtil.close();
    }
}
