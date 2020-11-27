package com.pearadmin.modules.student.service;

import com.pearadmin.modules.student.domain.Student;
import java.util.List;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.github.pagehelper.PageInfo;

/**
 * 学生 service
 * @author lwb
 * @email lwbldy@163.com
 * @date 2020-11-25 11:30:40
 */
public interface IStudentService {

    /**
     * 按条件查询数据
     * @param student
     * @return
     */
    List<Student> selectList(Student student);


    /**
     * 分页查询
     * @param student
     * @param pageDomain
     * @return
     */
    PageInfo<Student> page(Student student, PageDomain pageDomain);

    /**
     * 添加数据
     * @param student
     * @return 执行结果
     */
    Integer insert(Student student);


    /**
     * 根据 id 查询
     * @param id
     * @return
     */
    Student selectById(Integer id);


    /**
     * 根据 id 更新数据
     * @param student
     * @return
     */
    Integer updateById(Student student);


    /**
     * 根据 id 删除数据
     * @param id
     * @return
     */
    Integer deleteById(Integer id);


    /**
     * 根据 id 批量删除
     * @param ids
     * @return
     */
    Integer deleteByIds(Object[] ids);

}
