package com.pearadmin.common.plugins.generator.controller;


import com.alibaba.fastjson.JSON;
import com.pearadmin.common.plugins.generator.service.SysGeneratorService;
import com.pearadmin.common.plugins.generator.vo.TableConfVO;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.common.web.domain.response.ResultTable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Api(value="代码自动生成",tags={"代码自动生成"})
@Controller
@RequestMapping("system/gen")
public class GenController {

    private String prefix = "system/generator";

    @Autowired
    private SysGeneratorService sysGeneratorService;


    @GetMapping("/tableList")
    @ApiOperation(value="查询所有表页面")
    public String tableLists(){
        return prefix + "/tableLists";
    }

    @PostMapping("/tableList")
    @ApiOperation(value="查询所有表")
    @ResponseBody
    public ResultTable findAllTables(){
        List<Map<String, Object>> list = sysGeneratorService.queryList(null);
        int total = sysGeneratorService.queryTotal(null);
        return ResultTable.pageTable(total,list);
    }


    @GetMapping("/tableInfo/{tableName}")
    @ApiOperation(value="配置表信息自动生成代码页面")
    public String tableInfo(@PathVariable("tableName") String tableName, ModelMap map){
        TableConfVO table = sysGeneratorService.initTableInfo(tableName);
        String tableJSON = JSON.toJSONString(table);
        map.put("tableJSON",tableJSON);
        return prefix + "/tableInfo";
    }

    @PostMapping("/tableInfo")
    @ApiOperation(value="自动生成代码")
    @ResponseBody
    public Result initInfo(@RequestBody TableConfVO table)throws IOException {
        return sysGeneratorService.generatorCode(table);
    }

}
