package com.pearadmin.modules.cms.service.impl;

import com.pearadmin.modules.cms.domain.Goods;
import com.pearadmin.modules.cms.mapper.GoodsMapper;
import com.pearadmin.modules.cms.service.IGoodsService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("goodsService")
public class GoodsServiceImpl implements IGoodsService {



    @Resource
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> selectList(Goods param) {
        return goodsMapper.selectList(param);
    }

    @Override
    public PageInfo<Goods> page(Goods param, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        List<Goods> goodss = goodsMapper.selectList(param);
        return new PageInfo<>(goodss);
    }

    @Override
    public Integer insert(Goods goods) {
        return goodsMapper.insert(goods);
    }

    @Override
    public Goods selectById(Integer id) {
        return goodsMapper.selectById(id);
    }

    @Override
    public Integer updateById(Goods goods) {
        return goodsMapper.updateById(goods);
    }

    @Override
    public Integer deleteById(Integer id) {
        return goodsMapper.deleteById(id);
    }

    @Override
    public Integer deleteByIds(Object[] ids) {
        return goodsMapper.deleteByIds(ids);
    }

}
