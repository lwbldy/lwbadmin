package com.pearadmin.modules.cms.service;

import com.pearadmin.modules.cms.domain.Goods;
import java.util.List;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.github.pagehelper.PageInfo;

/**
 * 积分兑换 service
 * @author lwb
 * @email lwbldy@163.com
 * @date 2020-12-27 10:47:46
 */
public interface IGoodsService {

    /**
     * 按条件查询数据
     * @param goods
     * @return
     */
    List<Goods> selectList(Goods goods);


    /**
     * 分页查询
     * @param goods
     * @param pageDomain
     * @return
     */
    PageInfo<Goods> page(Goods goods, PageDomain pageDomain);

    /**
     * 添加数据
     * @param goods
     * @return 执行结果
     */
    Integer insert(Goods goods);


    /**
     * 根据 id 查询
     * @param id
     * @return
     */
    Goods selectById(Integer id);


    /**
     * 根据 id 更新数据
     * @param goods
     * @return
     */
    Integer updateById(Goods goods);


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
