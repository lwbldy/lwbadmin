package com.pearadmin.modules.cms.service;

import com.pearadmin.modules.cms.domain.Users;
import java.util.List;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.github.pagehelper.PageInfo;

/**
 * 用户 service
 * @author lwb
 * @email lwbldy@163.com
 * @date 2020-12-26 14:43:54
 */
public interface IUsersService {

    /**
     * 按条件查询数据
     * @param users
     * @return
     */
    List<Users> selectList(Users users);


    /**
     * 分页查询
     * @param users
     * @param pageDomain
     * @return
     */
    PageInfo<Users> page(Users users, PageDomain pageDomain);

    /**
     * 添加数据
     * @param users
     * @return 执行结果
     */
    Integer insert(Users users);


    /**
     * 根据 id 查询
     * @param id
     * @return
     */
    Users selectById(Integer id);

    /**
     * 根据 userName 查询
     * @param userName
     * @return
     */
    Users selectByUserName(String userName);


    /**
     * 根据 id 更新数据
     * @param users
     * @return
     */
    Integer updateById(Users users);


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
