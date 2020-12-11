package com.pearadmin.modules.cms.controller;


import com.pearadmin.modules.cms.domain.Clinic;
import com.pearadmin.modules.cms.service.IClinicService;


import com.github.pagehelper.PageInfo;
import com.pearadmin.common.tools.StringUtils;
import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.common.web.domain.response.ResultTable;
import com.pearadmin.modules.system.domain.SysDictData;
import com.pearadmin.modules.system.service.ISysDeptService;
import com.pearadmin.modules.system.service.ISysDictDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;


@RestController
@Api(tags = "医院信息")
@RequestMapping("/cms/clinic")
public class ClinicController extends BaseController {

    /**
     * Describe: 基础路径
     * */
    private static String MODULE_PATH = "cms/clinic/";


    @Resource
    private IClinicService clinicService;
    @Resource
    private ISysDictDataService sysDictDataService;

    @GetMapping("main")
    @ApiOperation(value="获取列表视图")
    @PreAuthorize("hasPermission('/cms/clinic/main','cms:clinic:main')")
    public ModelAndView main( ){
        return JumpPage(MODULE_PATH + "main");
    }


    @GetMapping("data")
    @ApiOperation(value="获取角色列表数据")
    @PreAuthorize("hasPermission('/cms/clinic/main','cms:clinic:main')")
    public ResultTable data(PageDomain pageDomain, Clinic param){
        PageInfo<Clinic> pageInfo = clinicService.page(param,pageDomain);
        return pageTable(pageInfo.getList(),pageInfo.getTotal());
    }

    @GetMapping("add")
    @ApiOperation(value="获取新增视图")
    @PreAuthorize("hasPermission('/cms/clinic/add','cms:clinic:add')")
    public ModelAndView add(ModelAndView modelAndView){
        SysDictData sysDictData = new SysDictData();
        sysDictData.setTypeCode("region");
        modelAndView.addObject("regionList",sysDictDataService.list(sysDictData));
        modelAndView.setViewName(MODULE_PATH + "add");
        return modelAndView;
    }


    /**
     * Describe: 保存信息
     * Param SysRole
     * Return 执行结果
     * */
    @PostMapping("save")
    @ApiOperation(value="保存数据")
    @PreAuthorize("hasPermission('/cms/clinic/add','cms:clinic:add')")
    public Result save(@RequestBody Clinic clinic){
        int result = clinicService.insert(clinic);
        return decide(result);
    }

    /**
     * Describe: 获取修改视图
     * Param ModelAndView
     * Return 修改视图
     * */
    @GetMapping("edit")
    @ApiOperation(value="获取修改视图")
    @PreAuthorize("hasPermission('/cms/clinic/edit','cms:clinic:edit')")
    public ModelAndView edit(ModelAndView modelAndView,int id){
        SysDictData sysDictData = new SysDictData();
        sysDictData.setTypeCode("region");
        modelAndView.addObject("regionList",sysDictDataService.list(sysDictData));

        modelAndView.addObject("clinic",clinicService.selectById(id));
        modelAndView.setViewName(MODULE_PATH + "edit");
        return modelAndView;
    }

    /**
     * Describe: 修改信息
     * Param SysRole
     * Return 执行结果
     * */
    @PutMapping("update")
    @ApiOperation(value="修改数据")
    @PreAuthorize("hasPermission('/cms/clinic/edit','cms:clinic:edit')")
    public Result update(@RequestBody Clinic clinic){
        int result = clinicService.updateById(clinic);
        return decide(result);
    }

    /**
     * Describe: 用户删除接口
     * Param: id
     * Return: ResuBean
     * */
    @DeleteMapping("remove/{id}")
    @ApiOperation(value="删除数据")
    @PreAuthorize("hasPermission('/cms/clinic/remove','cms:clinic:remove')")
    public Result remove(@PathVariable int id){
        int result  = clinicService.deleteById(id);
        return decide(result);
    }

    /**
     * Describe: 用户批量删除接口
     * Param: ids
     * Return: ResuBean
     * */
    @DeleteMapping("batchRemove/{ids}")
    @ApiOperation(value="批量删除数据")
    @PreAuthorize("hasPermission('/cms/clinic/remove','cms:clinic:remove')")
    public Result batchRemove(@PathVariable String ids){
        int result = clinicService.deleteByIds(StringUtils.StringToIntArr(ids.split(",")).toArray());
        return decide(1);
    }


}
