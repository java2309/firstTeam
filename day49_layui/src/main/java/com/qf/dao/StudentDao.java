package com.qf.dao;

import com.qf.entity.Student;

import java.util.List;

/**
 * description:
 * 公司:千锋教育
 * author:博哥
 * 公众号:Java架构栈
 */
public interface StudentDao {
    List<Student> selectAllStudentByName(String name);

    /**
     * 通过id删除一条数据
     * @param id
     * @return
     */
    int delStu(Integer id);

    static int addStu(Object[] objs) {
        return 0;
    }
}
