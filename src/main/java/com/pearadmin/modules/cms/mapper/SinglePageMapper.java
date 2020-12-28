package com.pearadmin.modules.cms.mapper;

import com.pearadmin.modules.cms.domain.SinglePage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SinglePageMapper {

    /**
     * 按条件查询数据
     * @param param
     * @return
     */
    List<SinglePage> selectList(SinglePage param);


    /**
     * 添加数据
     * @param param
     * @return 执行结果
     */
    Integer insert(SinglePage param);


    /**
     * 根据 id 查询
     * @param id
     * @return
     */
    SinglePage selectById(@Param("id") Integer id);

    /**
     * 根据 id 查询
     * @param url
     * @return
     */
    SinglePage selectByURL(@Param("url") String url);


    /**
     * 根据 id 更新数据
     * @param param
     * @return
     */
    Integer updateById(SinglePage param);


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
