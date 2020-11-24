package com.pearadmin.modules.test.mapper;

import com.pearadmin.modules.test.domain.TestTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestTableMapper {

    /**
     * 按条件查询数据
     * @param param
     * @return
     */
    List<TestTable> selectList(TestTable param);


    /**
     * 添加数据
     * @param param
     * @return 执行结果
     */
    Integer insert(TestTable param);


    /**
     * 根据 id 查询
     * @param id
     * @return
     */
    TestTable selectById(@Param("id") Integer id);


    /**
     * 根据 id 更新数据
     * @param param
     * @return
     */
    Integer updateById(TestTable param);


    /**
     * 根据 id 删除数据
     * @param id
     * @return
     */
    Integer deleteById(@Param("id") Integer id);


    /**
     * 根据 id 批量删除
     * @param ids
     * @return
     */
    Integer deleteByIds(Object[] ids);
}
