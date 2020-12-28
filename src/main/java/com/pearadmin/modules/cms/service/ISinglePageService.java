package com.pearadmin.modules.cms.service;

import com.pearadmin.modules.cms.domain.SinglePage;
import java.util.List;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.github.pagehelper.PageInfo;

/**
 * 单页 service
 * @author lwb
 * @email lwbldy@163.com
 * @date 2020-12-25 14:09:35
 */
public interface ISinglePageService {

    /**
     * 按条件查询数据
     * @param singlePage
     * @return
     */
    List<SinglePage> selectList(SinglePage singlePage);


    /**
     * 分页查询
     * @param singlePage
     * @param pageDomain
     * @return
     */
    PageInfo<SinglePage> page(SinglePage singlePage, PageDomain pageDomain);

    /**
     * 添加数据
     * @param singlePage
     * @return 执行结果
     */
    Integer insert(SinglePage singlePage);


    /**
     * 根据 id 查询
     * @param id
     * @return
     */
    SinglePage selectById(Integer id);

    /**
     * 根据 url 查询
     * @param url
     * @return
     */
    SinglePage selectByURL(String url);


    /**
     * 根据 id 更新数据
     * @param singlePage
     * @return
     */
    Integer updateById(SinglePage singlePage);


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
