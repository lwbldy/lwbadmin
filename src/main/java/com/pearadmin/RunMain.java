package com.pearadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({
        "com.pearadmin.modules.**.mapper",
        "com.pearadmin.common.plugins.logging.mapper",
        "com.pearadmin.common.plugins.resource.mapper",
        "com.pearadmin.common.plugins.generator.mapper",
})
public class RunMain {

    public static void main(String[] args) {
        SpringApplication.run(RunMain.class, args);
    }

}
