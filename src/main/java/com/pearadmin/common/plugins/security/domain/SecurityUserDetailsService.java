package com.pearadmin.common.plugins.security.domain;

import com.pearadmin.modules.system.domain.SysUser;
import com.pearadmin.modules.system.mapper.SysUserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * Describe: Security 用户服务
 * Author: 就 眠 仪 式
 * CreateTime: 2019/10/23
 * */
@Component
public class SecurityUserDetailsService implements UserDetailsService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser sysUser = sysUserMapper.selectByUsername(s);
        if(sysUser==null){
            throw new UsernameNotFoundException("Account Not");
        }
        SecurityUserDetails securityUserDetails = new SecurityUserDetails();
        securityUserDetails.setUserId(sysUser.getUserId());
        securityUserDetails.setRealName(sysUser.getRealName());
        securityUserDetails.setUsername(sysUser.getUsername());
        securityUserDetails.setPassword(sysUser.getPassword());
        securityUserDetails.setEnable(sysUser.getEnable());
        return securityUserDetails;
    }
}
