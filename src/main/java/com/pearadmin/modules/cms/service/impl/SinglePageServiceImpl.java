package com.pearadmin.modules.cms.service.impl;

import com.pearadmin.modules.cms.domain.SinglePage;
import com.pearadmin.modules.cms.mapper.SinglePageMapper;
import com.pearadmin.modules.cms.service.ISinglePageService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("singlePageService")
public class SinglePageServiceImpl implements ISinglePageService {



    @Resource
    SinglePageMapper singlePageMapper;

    @Override
    public List<SinglePage> selectList(SinglePage param) {
        return singlePageMapper.selectList(param);
    }

    @Override
    public PageInfo<SinglePage> page(SinglePage param, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        List<SinglePage> singlePages = singlePageMapper.selectList(param);
        return new PageInfo<>(singlePages);
    }

    @Override
    public Integer insert(SinglePage singlePage) {
        return singlePageMapper.insert(singlePage);
    }

    @Override
    public SinglePage selectById(Integer id) {
        return singlePageMapper.selectById(id);
    }

    @Override
    public SinglePage selectByURL(String url) {
        return singlePageMapper.selectByURL(url);
    }

    @Override
    public Integer updateById(SinglePage singlePage) {
        return singlePageMapper.updateById(singlePage);
    }

    @Override
    public Integer deleteById(Integer id) {
        return singlePageMapper.deleteById(id);
    }

    @Override
    public Integer deleteByIds(Object[] ids) {
        return singlePageMapper.deleteByIds(ids);
    }

}
