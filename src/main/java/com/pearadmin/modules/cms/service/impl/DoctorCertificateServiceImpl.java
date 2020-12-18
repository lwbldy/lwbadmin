package com.pearadmin.modules.cms.service.impl;

import com.pearadmin.modules.cms.domain.DoctorCertificate;
import com.pearadmin.modules.cms.mapper.DoctorCertificateMapper;
import com.pearadmin.modules.cms.service.IDoctorCertificateService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("doctorCertificateService")
public class DoctorCertificateServiceImpl implements IDoctorCertificateService {



    @Resource
    DoctorCertificateMapper doctorCertificateMapper;

    @Override
    public List<DoctorCertificate> selectList(DoctorCertificate param) {
        return doctorCertificateMapper.selectList(param);
    }

    @Override
    public PageInfo<DoctorCertificate> page(DoctorCertificate param, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        List<DoctorCertificate> doctorCertificates = doctorCertificateMapper.selectList(param);
        return new PageInfo<>(doctorCertificates);
    }

    @Override
    public Integer insert(DoctorCertificate doctorCertificate) {
        return doctorCertificateMapper.insert(doctorCertificate);
    }

    @Override
    public DoctorCertificate selectById(Integer id) {
        return doctorCertificateMapper.selectById(id);
    }

    @Override
    public Integer updateById(DoctorCertificate doctorCertificate) {
        return doctorCertificateMapper.updateById(doctorCertificate);
    }

    @Override
    public Integer deleteById(Integer id) {
        return doctorCertificateMapper.deleteById(id);
    }

    @Override
    public Integer deleteByIds(Object[] ids) {
        return doctorCertificateMapper.deleteByIds(ids);
    }

}
