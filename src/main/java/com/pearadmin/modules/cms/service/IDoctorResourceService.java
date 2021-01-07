package com.pearadmin.modules.cms.service;

import com.pearadmin.modules.cms.domain.DoctorResource;
import java.util.List;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.github.pagehelper.PageInfo;

/**
 * 医生 service
 * @author lwb
 * @email lwbldy@163.com
 * @date 2020-12-14 16:18:04
 */
public interface IDoctorResourceService {

    /**
     * 按条件查询数据
     * @param doctorResource
     * @return
     */
    List<DoctorResource> selectList(DoctorResource doctorResource);

    /**
     * 按条件查询数据
     * @param doctorResource
     * @return
     */
    List<DoctorResource> selectList2(DoctorResource doctorResource);

    /**
     * 分页查询
     * @param doctorResource
     * @param pageDomain
     * @return
     */
    PageInfo<DoctorResource> page(DoctorResource doctorResource, PageDomain pageDomain);

    /**
     * 分页查询
     * @param doctorResource
     * @param pageDomain
     * @return
     */
    PageInfo<DoctorResource> page2(DoctorResource doctorResource, PageDomain pageDomain);

    /**
     * 添加数据
     * @param doctorResource
     * @return 执行结果
     */
    Integer insert(DoctorResource doctorResource);


    /**
     * 根据 id 查询
     * @param id
     * @return
     */
    DoctorResource selectById(Integer id);


    /**
     * 根据 id 更新数据
     * @param doctorResource
     * @return
     */
    Integer updateById(DoctorResource doctorResource);


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

    /**
     * 查询医生总数
     * @return
     */
    int selectAllCount();

}
