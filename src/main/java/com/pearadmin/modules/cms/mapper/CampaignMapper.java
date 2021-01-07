package com.pearadmin.modules.cms.mapper;

import com.pearadmin.modules.cms.domain.Campaign;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CampaignMapper {

    /**
     * 按条件查询数据
     * @param param
     * @return
     */
    List<Campaign> selectList(Campaign param);


    /**
     * 添加数据
     * @param param
     * @return 执行结果
     */
    Integer insert(Campaign param);


    /**
     * 根据 id 查询
     * @param id
     * @return
     */
    Campaign selectById(@Param("id") Integer id);


    /**
     * 根据 id 更新数据
     * @param param
     * @return
     */
    Integer updateById(Campaign param);


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
