package com.pearadmin.modules.test.service;

import com.pearadmin.modules.test.domain.TestTable;
import java.util.List;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.github.pagehelper.PageInfo;

/**
 *  service
 * @author lwb
 * @email lwbldy@163.com
 * @date 2020-11-19 20:57:16
 */
public interface ITestTableService {

    /**
     * 按条件查询数据
     * @param testTable
     * @return
     */
    List<TestTable> selectList(TestTable testTable);


    /**
     * 分页查询
     * @param testTable
     * @param pageDomain
     * @return
     */
    PageInfo<TestTable> page(TestTable testTable, PageDomain pageDomain);

    /**
     * 添加数据
     * @param testTable
     * @return 执行结果
     */
    Integer insert(TestTable testTable);


    /**
     * 根据 id 查询
     * @param id
     * @return
     */
    TestTable selectById(Integer id);


    /**
     * 根据 id 更新数据
     * @param testTable
     * @return
     */
    Integer updateById(TestTable testTable);


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
