package com.pearadmin.modules.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.tools.sequence.SequenceUtil;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.modules.system.domain.SysRole;
import com.pearadmin.modules.system.domain.SysUser;
import com.pearadmin.modules.system.domain.SysUserRole;
import com.pearadmin.modules.system.mapper.SysPowerMapper;
import com.pearadmin.modules.system.mapper.SysRoleMapper;
import com.pearadmin.modules.system.mapper.SysUserMapper;
import com.pearadmin.modules.system.mapper.SysUserRoleMapper;
import com.pearadmin.modules.system.domain.SysMenu;
import com.pearadmin.modules.system.service.ISysUserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Describe: 用户服务实现类
 * Author: 就 眠 仪 式
 * CreateTime: 2019/10/23
 * */
@Service
public class SysUserServiceImpl implements ISysUserService {

    /**
     * 注入用户服务
     * */
    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 注入用户角色服务
     * */
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * 注入角色服务
     * */
    @Resource
    private SysRoleMapper sysRoleMapper;

    /**
     * 注入权限服务
     * */
    @Resource
    private SysPowerMapper sysPowerMapper;

    /**
     * Describe: 根据条件查询用户列表数据
     * Param: username
     * Return: 返回用户列表数据
     * */
    @Override
    public List<SysUser> list(SysUser param) {
        List<SysUser> sysUsers = sysUserMapper.selectList(param);
        return sysUsers;
    }

    /**
     * Describe: 根据条件查询用户列表数据  分页
     * Param: username
     * Return: 返回分页用户列表数据
     * */
    @Override
    public PageInfo<SysUser> page(SysUser param, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        List<SysUser> sysUsers = sysUserMapper.selectList(param);
        return new PageInfo<>(sysUsers);
    }

    /**
     * Describe: 根据 ID 查询用户
     * Param: id
     * Return: 返回用户信息
     * */
    @Override
    public SysUser getById(String id) {
        return sysUserMapper.selectById(id);
    }

    /**
     * Describe: 根据 id 删除用户数据
     * Param: id
     * Return: Boolean
     * */
    @Override
    public boolean remove(String id) {
        int result = sysUserMapper.deleteById(id);
        if(result>0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Describe: 根据 id 批量删除用户数据
     * Param: ids
     * Return: Boolean
     * */
    @Override
    public boolean batchRemove(String[] ids) {
        int result = sysUserMapper.deleteByIds(ids);
        if(result>0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Describe: 保存用户数据
     * Param: SysUser
     * Return: 操作结果
     * */
    @Override
    public boolean save(SysUser sysUser) {
        int result = sysUserMapper.insert(sysUser);
        if(result>0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Describe: 修改用户数据
     * Param: SysUser
     * Return: 操作结果
     * */
    @Override
    public boolean update(SysUser sysUser) {
        Integer result = sysUserMapper.updateById(sysUser);
        if(result > 0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Describe: 保存用户角色数据
     * Param: SysUser
     * Return: 操作结果
     * */
    @Override
    public boolean saveUserRole(String userId, List<String> roleIds) {
        sysUserRoleMapper.deleteByUserId(userId);
        List<SysUserRole> sysUserRoles = new ArrayList<>();
        roleIds.forEach(roleId->{
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setId(SequenceUtil.makeStringId());
            sysUserRole.setRoleId(roleId);
            sysUserRole.setUserId(userId);
            sysUserRoles.add(sysUserRole);
        });
        int i = sysUserRoleMapper.batchInsert(sysUserRoles);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Describe: 获取
     * Param: SysUser
     * Return: 操作结果
     * */
    public List<SysRole> getUserRole(String userId){
        List<SysRole> allRole = sysRoleMapper.selectList(null);
        List<SysUserRole> myRole = sysUserRoleMapper.selectByUserId(userId);
        allRole.forEach(sysRole->{
            myRole.forEach(sysUserRole->{
                if(sysRole.getRoleId().equals(sysUserRole.getRoleId()))sysRole.setChecked(true);
            });
        });
        return allRole;
    }

    /**
     * Describe: 获取用户菜单
     * Param: username
     * Return: Result
     * */
    @Override
    public List<SysMenu> getUserMenu(String username) {
//        List<SysMenu> menus = sysPowerMapper.selectMenuByUsername(username);
//        buildMenu(menus,username);
        List<SysMenu> menus = sysPowerMapper.selectMenuAllByUsername(username);

        List<SysMenu> menuList = new ArrayList<SysMenu>();
        for(SysMenu sysMenu : menus){
            if(sysMenu.getParentId().trim().equals("0")){
                menuList.add(sysMenu);
            }
        }

        //为所有一菜单设置子菜单
        for (SysMenu menu : menuList) {
            menu.setChildren(getChild(menu.getId(),menus));
        }

        return menuList;
    }

    public List<SysMenu> getChild(String id,List<SysMenu> rootMenu){
        List<SysMenu> childList = new ArrayList<SysMenu>();
        //循环所有菜单
        for(SysMenu menu:rootMenu){
            //如果是和父id相同
            if(menu.getParentId().trim().equals(id)){
                childList.add(menu);
            }
        }
        //再循环一遍 子菜单，如果有值，则继续循环下去。如果没有值返回空
        for(SysMenu menu : childList){
            getChild(menu.getId(),rootMenu);
        }
        if(childList.size() == 0){
            return null;
        }
        return childList;
    }

    /**
     * Describe: 菜单递归构建
     * Param: menus username
     * Return: null
     * */
    private void buildMenu(List<SysMenu> menus, String username){
        if(menus.size()<=0) return;
        for (SysMenu menu : menus) {
            menu.setChildren(sysPowerMapper.selectMenuByParentId(username,menu.getId()));
            buildMenu(menu.getChildren(),username);
        }
    }

}
