package com.pearadmin.modules.cms.service.impl;

import com.pearadmin.modules.cms.domain.Users;
import com.pearadmin.modules.cms.mapper.UsersMapper;
import com.pearadmin.modules.cms.service.IUsersService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("usersService")
public class UsersServiceImpl implements IUsersService {



    @Resource
    UsersMapper usersMapper;

    @Override
    public List<Users> selectList(Users param) {
        return usersMapper.selectList(param);
    }

    @Override
    public PageInfo<Users> page(Users param, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        List<Users> userss = usersMapper.selectList(param);
        return new PageInfo<>(userss);
    }

    @Override
    public Integer insert(Users users) {
        return usersMapper.insert(users);
    }

    @Override
    public Users selectById(Integer id) {
        return usersMapper.selectById(id);
    }

    @Override
    public Users selectByUserName(String userName) {
        return usersMapper.selectByUserName(userName);
    }

    @Override
    public Integer updateById(Users users) {
        return usersMapper.updateById(users);
    }

    @Override
    public Integer deleteById(Integer id) {
        return usersMapper.deleteById(id);
    }

    @Override
    public Integer deleteByIds(Object[] ids) {
        return usersMapper.deleteByIds(ids);
    }

}
