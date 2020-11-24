package com.pearadmin.modules.test.service.impl;

import com.pearadmin.modules.test.domain.TestTable;
import com.pearadmin.modules.test.mapper.TestTableMapper;
import com.pearadmin.modules.test.service.ITestTableService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("testTableService")
public class TestTableServiceImpl implements ITestTableService {



    @Resource
    TestTableMapper testTableMapper;

    @Override
    public List<TestTable> selectList(TestTable param) {
        return testTableMapper.selectList(param);
    }

    @Override
    public PageInfo<TestTable> page(TestTable param, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        List<TestTable> testTables = testTableMapper.selectList(param);
        return new PageInfo<>(testTables);
    }

    @Override
    public Integer insert(TestTable testTable) {
        return testTableMapper.insert(testTable);
    }

    @Override
    public TestTable selectById(Integer id) {
        return testTableMapper.selectById(id);
    }

    @Override
    public Integer updateById(TestTable testTable) {
        return testTableMapper.updateById(testTable);
    }

    @Override
    public Integer deleteById(Integer id) {
        return testTableMapper.deleteById(id);
    }

    @Override
    public Integer deleteByIds(Object[] ids) {
        return testTableMapper.deleteByIds(ids);
    }

}
