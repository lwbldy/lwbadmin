package com.pearadmin.modules.cms.controller;


import com.pearadmin.modules.cms.domain.DoctorCertificate;
import com.pearadmin.modules.cms.service.IDoctorCertificateService;


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
@Api(tags = "医生证书")
@RequestMapping("/cms/doctorcertificate")
public class DoctorCertificateController extends BaseController {

    /**
     * Describe: 基础路径
     * */
    private static String MODULE_PATH = "cms/doctorcertificate/";


    @Resource
    private IDoctorCertificateService doctorCertificateService;

    @GetMapping("main")
    @ApiOperation(value="获取列表视图")
    //@PreAuthorize("hasPermission('/cms/doctorcertificate/main','cms:doctorCertificate:main')")
    public ModelAndView main(int id,ModelAndView modelAndView){
        modelAndView.addObject("id",id);
        modelAndView.setViewName(MODULE_PATH + "main");
        return modelAndView;
    }


    @GetMapping("data")
    @ApiOperation(value="获取角色列表数据")
    //@PreAuthorize("hasPermission('/cms/doctorcertificate/main','cms:doctorcertificate:main')")
    public ResultTable data(PageDomain pageDomain, DoctorCertificate param){
        PageInfo<DoctorCertificate> pageInfo = doctorCertificateService.page(param,pageDomain);
        return pageTable(pageInfo.getList(),pageInfo.getTotal());
    }

    @GetMapping("add")
    @ApiOperation(value="获取新增视图")
    //@PreAuthorize("hasPermission('/cms/doctorcertificate/add','cms:doctorcertificate:add')")
    public ModelAndView add(int id,ModelAndView modelAndView){
        modelAndView.addObject("id",id);
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
    //@PreAuthorize("hasPermission('/cms/doctorcertificate/add','cms:doctorcertificate:add')")
    public Result save(@RequestBody DoctorCertificate doctorCertificate){
        int result = doctorCertificateService.insert(doctorCertificate);
        return decide(result);
    }

    /**
     * Describe: 获取修改视图
     * Param ModelAndView
     * Return 修改视图
     * */
    @GetMapping("edit")
    @ApiOperation(value="获取修改视图")
    //@PreAuthorize("hasPermission('/cms/doctorcertificate/edit','cms:doctorcertificate:edit')")
    public ModelAndView edit(ModelAndView modelAndView,int id){
        modelAndView.addObject("doctorCertificate",doctorCertificateService.selectById(id));
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
    //@PreAuthorize("hasPermission('/cms/doctorcertificate/edit','cms:doctorcertificate:edit')")
    public Result update(@RequestBody DoctorCertificate doctorCertificate){
        int result = doctorCertificateService.updateById(doctorCertificate);
        return decide(result);
    }

    /**
     * Describe: 用户删除接口
     * Param: id
     * Return: ResuBean
     * */
    @DeleteMapping("remove/{id}")
    @ApiOperation(value="删除数据")
    //@PreAuthorize("hasPermission('/cms/doctorcertificate/remove','cms:doctorcertificate:remove')")
    public Result remove(@PathVariable int id){
        int result  = doctorCertificateService.deleteById(id);
        return decide(result);
    }

    /**
     * Describe: 用户批量删除接口
     * Param: ids
     * Return: ResuBean
     * */
    @DeleteMapping("batchRemove/{ids}")
    @ApiOperation(value="批量删除数据")
    //@PreAuthorize("hasPermission('/cms/doctorcertificate/remove','cms:doctorcertificate:remove')")
    public Result batchRemove(@PathVariable String ids){
        int result = doctorCertificateService.deleteByIds(StringUtils.StringToIntArr(ids.split(",")).toArray());
        return decide(1);
    }


}
