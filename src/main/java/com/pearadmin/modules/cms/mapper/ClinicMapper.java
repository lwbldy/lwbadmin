package com.pearadmin.modules.cms.mapper;

import com.pearadmin.modules.cms.domain.Clinic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClinicMapper {

    /**
     * 按条件查询数据
     * @param param
     * @return
     */
    List<Clinic> selectList(Clinic param);


    /**
     * 添加数据
     * @param param
     * @return 执行结果
     */
    Integer insert(Clinic param);


    /**
     * 根据 id 查询
     * @param id
     * @return
     */
    Clinic selectById(@Param("id") Integer id);


    /**
     * 根据 id 更新数据
     * @param param
     * @return
     */
    Integer updateById(Clinic param);


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
