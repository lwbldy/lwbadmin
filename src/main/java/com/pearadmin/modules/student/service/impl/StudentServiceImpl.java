package com.pearadmin.modules.student.service.impl;

import com.pearadmin.modules.student.domain.Student;
import com.pearadmin.modules.student.mapper.StudentMapper;
import com.pearadmin.modules.student.service.IStudentService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements IStudentService {



    @Resource
    StudentMapper studentMapper;

    @Override
    public List<Student> selectList(Student param) {
        return studentMapper.selectList(param);
    }

    @Override
    public PageInfo<Student> page(Student param, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        List<Student> students = studentMapper.selectList(param);
        return new PageInfo<>(students);
    }

    @Override
    public Integer insert(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public Student selectById(Integer id) {
        return studentMapper.selectById(id);
    }

    @Override
    public Integer updateById(Student student) {
        return studentMapper.updateById(student);
    }

    @Override
    public Integer deleteById(Integer id) {
        return studentMapper.deleteById(id);
    }

    @Override
    public Integer deleteByIds(Object[] ids) {
        return studentMapper.deleteByIds(ids);
    }

}
