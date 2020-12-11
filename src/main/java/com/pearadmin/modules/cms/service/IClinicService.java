package com.pearadmin.modules.cms.service;

import com.pearadmin.modules.cms.domain.Clinic;
import java.util.List;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.github.pagehelper.PageInfo;

/**
 * 医院信息 service
 * @author lwb
 * @email lwbldy@163.com
 * @date 2020-12-10 10:45:34
 */
public interface IClinicService {

    /**
     * 按条件查询数据
     * @param clinic
     * @return
     */
    List<Clinic> selectList(Clinic clinic);


    /**
     * 分页查询
     * @param clinic
     * @param pageDomain
     * @return
     */
    PageInfo<Clinic> page(Clinic clinic, PageDomain pageDomain);

    /**
     * 添加数据
     * @param clinic
     * @return 执行结果
     */
    Integer insert(Clinic clinic);


    /**
     * 根据 id 查询
     * @param id
     * @return
     */
    Clinic selectById(Integer id);


    /**
     * 根据 id 更新数据
     * @param clinic
     * @return
     */
    Integer updateById(Clinic clinic);


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
