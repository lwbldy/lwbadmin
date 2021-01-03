package com.pearadmin.modules.cms.service.impl;

import com.pearadmin.modules.cms.domain.Dental;
import com.pearadmin.modules.cms.mapper.DentalMapper;
import com.pearadmin.modules.cms.service.IDentalService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("dentalService")
public class DentalServiceImpl implements IDentalService {



    @Resource
    DentalMapper dentalMapper;

    @Override
    public List<Dental> selectList(Dental param) {
        return dentalMapper.selectList(param);
    }

    @Override
    public PageInfo<Dental> page(Dental param, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        List<Dental> dentals = dentalMapper.selectList(param);
        return new PageInfo<>(dentals);
    }

    @Override
    public Integer insert(Dental dental) {
        return dentalMapper.insert(dental);
    }

    @Override
    public Dental selectById(Integer id) {
        return dentalMapper.selectById(id);
    }

    @Override
    public Integer updateById(Dental dental) {
        return dentalMapper.updateById(dental);
    }

    @Override
    public Integer deleteById(Integer id) {
        return dentalMapper.deleteById(id);
    }

    @Override
    public Integer updateHits(Integer id) {
        return dentalMapper.updateHits(id);
    }

    @Override
    public Integer deleteByIds(Object[] ids) {
        return dentalMapper.deleteByIds(ids);
    }

}
