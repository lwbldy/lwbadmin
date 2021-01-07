package com.pearadmin.modules.cms.service.impl;

import com.pearadmin.modules.cms.domain.Campaign;
import com.pearadmin.modules.cms.mapper.CampaignMapper;
import com.pearadmin.modules.cms.service.ICampaignService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("campaignService")
public class CampaignServiceImpl implements ICampaignService {



    @Resource
    CampaignMapper campaignMapper;

    @Override
    public List<Campaign> selectList(Campaign param) {
        return campaignMapper.selectList(param);
    }

    @Override
    public PageInfo<Campaign> page(Campaign param, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        List<Campaign> campaigns = campaignMapper.selectList(param);
        return new PageInfo<>(campaigns);
    }

    @Override
    public Integer insert(Campaign campaign) {
        return campaignMapper.insert(campaign);
    }

    @Override
    public Campaign selectById(Integer id) {
        return campaignMapper.selectById(id);
    }

    @Override
    public Integer updateById(Campaign campaign) {
        return campaignMapper.updateById(campaign);
    }

    @Override
    public Integer deleteById(Integer id) {
        return campaignMapper.deleteById(id);
    }

    @Override
    public Integer deleteByIds(Object[] ids) {
        return campaignMapper.deleteByIds(ids);
    }

}
