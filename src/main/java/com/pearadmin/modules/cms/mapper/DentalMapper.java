package com.pearadmin.modules.cms.mapper;

import com.pearadmin.modules.cms.domain.Dental;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DentalMapper {

    /**
     * 按条件查询数据
     * @param param
     * @return
     */
    List<Dental> selectList(Dental param);



    /**
     * 查询单页
     * @param param
     * @return
     */
    List<Dental> selectList2(Dental param);


    /**
     * 添加数据
     * @param param
     * @return 执行结果
     */
    Integer insert(Dental param);


    /**
     * 根据 id 查询
     * @param id
     * @return
     */
    Dental selectById(@Param("id") Integer id);

    /**
     * 根据url查询
     * @param url
     * @return
     */
    Dental selectByURL(@Param("url") String url);


    /**
     * 根据 id 更新数据
     * @param param
     * @return
     */
    Integer updateById(Dental param);

    /**
     * 根据id更新点击次数
     * @param id
     * @return
     */
    Integer updateHits(@Param("id") Integer id);


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
