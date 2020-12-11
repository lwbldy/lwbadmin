package com.pearadmin.modules.cms.service.impl;

import com.pearadmin.modules.cms.domain.Clinic;
import com.pearadmin.modules.cms.mapper.ClinicMapper;
import com.pearadmin.modules.cms.service.IClinicService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("clinicService")
public class ClinicServiceImpl implements IClinicService {

    @Resource
    ClinicMapper clinicMapper;

    @Override
    public List<Clinic> selectList(Clinic param) {
        return clinicMapper.selectList(param);
    }

    @Override
    public PageInfo<Clinic> page(Clinic param, PageDomain pageDomain) {

        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        List<Clinic> clinics = clinicMapper.selectList(param);
        return new PageInfo<>(clinics);
    }

    @Override
    public Integer insert(Clinic clinic) {
        return clinicMapper.insert(clinic);
    }

    @Override
    public Clinic selectById(Integer id) {
        return clinicMapper.selectById(id);
    }

    @Override
    public Integer updateById(Clinic clinic) {
        return clinicMapper.updateById(clinic);
    }

    @Override
    public Integer deleteById(Integer id) {
        return clinicMapper.deleteById(id);
    }

    @Override
    public Integer deleteByIds(Object[] ids) {
        return clinicMapper.deleteByIds(ids);
    }

}
