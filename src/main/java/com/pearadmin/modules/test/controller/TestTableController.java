package com.pearadmin.modules.test.controller;


import com.pearadmin.modules.test.domain.TestTable;
import com.pearadmin.modules.test.service.ITestTableService;


import com.github.pagehelper.PageInfo;
import com.pearadmin.common.tools.StringUtils;
import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.common.web.domain.response.ResultTable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;


@RestController
@Api(tags = "")
@RequestMapping("/test/testtable")
public class TestTableController extends BaseController {

    /**
         * Describe: 基础路径
         * */
    private static String MODULE_PATH = "test/testtable/";


    @Resource
    private ITestTableService testTableService;

    @GetMapping("main")
    @ApiOperation(value="获取列表视图")
    //@PreAuthorize("hasPermission('/test/testtable/main','testTable:main')")
    public ModelAndView main( ){
        return JumpPage(MODULE_PATH + "main");
    }


    @GetMapping("data")
    @ApiOperation(value="获取角色列表数据")
    //@PreAuthorize("hasPermission('/test/testtable/data','test:testtable:data')")
    public ResultTable data(PageDomain pageDomain, TestTable param){
        PageInfo<TestTable> pageInfo = testTableService.page(param,pageDomain);
        return pageTable(pageInfo.getList(),pageInfo.getTotal());
    }

    @GetMapping("add")
    @ApiOperation(value="获取角色新增视图")
    //@PreAuthorize("hasPermission('/test/testtable/add','test:testtable:add')")
    public ModelAndView add(){
        return JumpPage(MODULE_PATH + "add");
    }


    /**
     * Describe: 保存角色信息
     * Param SysRole
     * Return 执行结果
     * */
    @PostMapping("save")
    @ApiOperation(value="保存角色数据")
    //@PreAuthorize("hasPermission('/test/testtable/add','test:testtable:add')")
    public Result save(@RequestBody TestTable testTable){
        int result = testTableService.insert(testTable);
        return decide(result);
    }

    /**
     * Describe: 获取角色修改视图
     * Param ModelAndView
     * Return 角色修改视图
     * */
    @GetMapping("edit")
    @ApiOperation(value="获取角色修改视图")
    //@PreAuthorize("hasPermission('/test/testtable/edit','test:testtable:edit')")
    public ModelAndView edit(ModelAndView modelAndView,int id){
        modelAndView.addObject("testTable",testTableService.selectById(id));
        modelAndView.setViewName(MODULE_PATH + "edit");
        return modelAndView;
    }

    /**
     * Describe: 修改角色信息
     * Param SysRole
     * Return 执行结果
     * */
    @PutMapping("update")
    @ApiOperation(value="修改角色数据")
    //@PreAuthorize("hasPermission('/test/testtable/edit','test:testtable:edit')")
    public Result update(@RequestBody TestTable testTable){
        int result = testTableService.updateById(testTable);
        return decide(result);
    }

    /**
     * Describe: 用户删除接口
     * Param: id
     * Return: ResuBean
     * */
    @DeleteMapping("remove/{id}")
    @ApiOperation(value="删除角色数据")
    //@PreAuthorize("hasPermission('/test/testtable/remove','test:testtable:remove')")
    public Result remove(@PathVariable int id){
        int result  = testTableService.deleteById(id);
        return decide(result);
    }

    /**
     * Describe: 用户批量删除接口
     * Param: ids
     * Return: ResuBean
     * */
    @DeleteMapping("batchRemove/{ids}")
    @ApiOperation(value="批量删除角色数据")
    //@PreAuthorize("hasPermission('/test/testtable/remove','test:testtable:remove')")
    public Result batchRemove(@PathVariable String ids){
        int result = testTableService.deleteByIds(StringUtils.StringToIntArr(ids.split(",")).toArray());
        return decide(1);
    }


}
