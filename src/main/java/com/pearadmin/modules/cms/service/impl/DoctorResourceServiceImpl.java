package com.pearadmin.modules.cms.service.impl;

import com.pearadmin.modules.cms.domain.DoctorResource;
import com.pearadmin.modules.cms.mapper.DoctorResourceMapper;
import com.pearadmin.modules.cms.service.IDoctorResourceService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("doctorResourceService")
public class DoctorResourceServiceImpl implements IDoctorResourceService {



    @Resource
    DoctorResourceMapper doctorResourceMapper;

    @Override
    public List<DoctorResource> selectList(DoctorResource param) {
        return doctorResourceMapper.selectList(param);
    }

    @Override
    public List<DoctorResource> selectList2(DoctorResource param) {
        return doctorResourceMapper.selectList2(param);
    }

    @Override
    public PageInfo<DoctorResource> page(DoctorResource param, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        List<DoctorResource> doctorResources = doctorResourceMapper.selectList(param);
        return new PageInfo<>(doctorResources);
    }

    @Override
    public PageInfo<DoctorResource> page2(DoctorResource param, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        List<DoctorResource> doctorResources = doctorResourceMapper.selectList2(param);
        return new PageInfo<>(doctorResources);
    }

    @Override
    public Integer insert(DoctorResource doctorResource) {
        return doctorResourceMapper.insert(doctorResource);
    }

    @Override
    public DoctorResource selectById(Integer id) {
        return doctorResourceMapper.selectById(id);
    }

    @Override
    public Integer updateById(DoctorResource doctorResource) {
        return doctorResourceMapper.updateById(doctorResource);
    }

    @Override
    public Integer deleteById(Integer id) {
        return doctorResourceMapper.deleteById(id);
    }

    @Override
    public Integer deleteByIds(Object[] ids) {
        return doctorResourceMapper.deleteByIds(ids);
    }

}
