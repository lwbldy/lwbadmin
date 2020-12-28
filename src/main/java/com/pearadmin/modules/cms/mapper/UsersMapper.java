package com.pearadmin.modules.cms.mapper;

import com.pearadmin.modules.cms.domain.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersMapper {

    /**
     * 按条件查询数据
     * @param param
     * @return
     */
    List<Users> selectList(Users param);


    /**
     * 添加数据
     * @param param
     * @return 执行结果
     */
    Integer insert(Users param);


    /**
     * 根据 id 查询
     * @param id
     * @return
     */
    Users selectById(@Param("id") Integer id);

    /**
     * 根据 userName 查询
     * @param userName
     * @return
     */
    Users selectByUserName(@Param("userName") String userName);


    /**
     * 根据 id 更新数据
     * @param param
     * @return
     */
    Integer updateById(Users param);


    /**
     * 根据 id 删除数据
     * @param id
     * @return
     */
    Integer deleteById(@Param("id") Integer id);


    /**
     * 根据 id 批量删除
     * @param ids
     * @return
     */
    Integer deleteByIds(Object[] ids);
}
