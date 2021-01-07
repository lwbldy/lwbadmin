package com.pearadmin.modules.cms.service;

import com.pearadmin.modules.cms.domain.Campaign;
import java.util.List;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.github.pagehelper.PageInfo;

/**
 * 活动宣传 service
 * @author lwb
 * @email lwbldy@163.com
 * @date 2021-01-05 11:09:51
 */
public interface ICampaignService {

    /**
     * 按条件查询数据
     * @param campaign
     * @return
     */
    List<Campaign> selectList(Campaign campaign);


    /**
     * 分页查询
     * @param campaign
     * @param pageDomain
     * @return
     */
    PageInfo<Campaign> page(Campaign campaign, PageDomain pageDomain);

    /**
     * 添加数据
     * @param campaign
     * @return 执行结果
     */
    Integer insert(Campaign campaign);


    /**
     * 根据 id 查询
     * @param id
     * @return
     */
    Campaign selectById(Integer id);


    /**
     * 根据 id 更新数据
     * @param campaign
     * @return
     */
    Integer updateById(Campaign campaign);


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
