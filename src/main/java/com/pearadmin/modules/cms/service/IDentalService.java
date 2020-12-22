package com.pearadmin.modules.cms.service;

import com.pearadmin.modules.cms.domain.Dental;
import java.util.List;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.github.pagehelper.PageInfo;

/**
 * 牙齿文章 service
 * @author lwb
 * @email lwbldy@163.com
 * @date 2020-12-22 14:00:42
 */
public interface IDentalService {

    /**
     * 按条件查询数据
     * @param dental
     * @return
     */
    List<Dental> selectList(Dental dental);


    /**
     * 分页查询
     * @param dental
     * @param pageDomain
     * @return
     */
    PageInfo<Dental> page(Dental dental, PageDomain pageDomain);

    /**
     * 添加数据
     * @param dental
     * @return 执行结果
     */
    Integer insert(Dental dental);


    /**
     * 根据 id 查询
     * @param id
     * @return
     */
    Dental selectById(Integer id);


    /**
     * 根据 id 更新数据
     * @param dental
     * @return
     */
    Integer updateById(Dental dental);


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
