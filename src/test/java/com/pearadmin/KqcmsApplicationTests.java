package com.pearadmin;

import com.pearadmin.modules.system.domain.SysUser;
import com.pearadmin.modules.system.mapper.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KqcmsApplicationTests {

	@Autowired
	SysUserMapper sysUserMapper;

	@Test
	void contextLoads() {
		SysUser user = sysUserMapper.selectByUsername("admin");
		System.out.println(user);
	}


}
