package com.pearadmin.modules.cms.service;

import com.pearadmin.modules.cms.domain.DoctorCertificate;
import java.util.List;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.github.pagehelper.PageInfo;

/**
 * 医生证书 service
 * @author lwb
 * @email lwbldy@163.com
 * @date 2020-12-18 11:33:11
 */
public interface IDoctorCertificateService {

    /**
     * 按条件查询数据
     * @param doctorCertificate
     * @return
     */
    List<DoctorCertificate> selectList(DoctorCertificate doctorCertificate);


    /**
     * 分页查询
     * @param doctorCertificate
     * @param pageDomain
     * @return
     */
    PageInfo<DoctorCertificate> page(DoctorCertificate doctorCertificate, PageDomain pageDomain);

    /**
     * 添加数据
     * @param doctorCertificate
     * @return 执行结果
     */
    Integer insert(DoctorCertificate doctorCertificate);


    /**
     * 根据 id 查询
     * @param id
     * @return
     */
    DoctorCertificate selectById(Integer id);


    /**
     * 根据 id 更新数据
     * @param doctorCertificate
     * @return
     */
    Integer updateById(DoctorCertificate doctorCertificate);


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
