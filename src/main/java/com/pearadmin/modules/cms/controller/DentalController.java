package com.pearadmin.modules.cms.controller;


import com.pearadmin.modules.cms.domain.Dental;
import com.pearadmin.modules.cms.service.IDentalService;


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
import java.time.LocalDate;
import java.util.Date;


@RestController
@Api(tags = "牙齿文章")
@RequestMapping("/cms/dental")
public class DentalController extends BaseController {

    /**
         * Describe: 基础路径
         * */
    private static String MODULE_PATH = "cms/dental/";


    @Resource
    private IDentalService dentalService;

    @GetMapping("main")
    @ApiOperation(value="获取列表视图")
    @PreAuthorize("hasPermission('/cms/dental/main','cms:dental:main')")
    public ModelAndView main( ){
        return JumpPage(MODULE_PATH + "main");
    }


    @GetMapping("data")
    @ApiOperation(value="获取角色列表数据")
    @PreAuthorize("hasPermission('/cms/dental/main','cms:dental:main')")
    public ResultTable data(PageDomain pageDomain, Dental param){
        PageInfo<Dental> pageInfo = dentalService.page(param,pageDomain);
        return pageTable(pageInfo.getList(),pageInfo.getTotal());
    }

    @GetMapping("add")
    @ApiOperation(value="获取新增视图")
    @PreAuthorize("hasPermission('/cms/dental/add','cms:dental:add')")
    public ModelAndView add(){
        return JumpPage(MODULE_PATH + "add");
    }


    /**
     * Describe: 保存信息
     * Param SysRole
     * Return 执行结果
     * */
    @PostMapping("save")
    @ApiOperation(value="保存数据")
    @PreAuthorize("hasPermission('/cms/dental/add','cms:dental:add')")
    public Result save(@RequestBody Dental dental){

        dental.setCreatTime(new Date());

        int result = dentalService.insert(dental);
        return decide(result);
    }

    /**
     * Describe: 获取修改视图
     * Param ModelAndView
     * Return 修改视图
     * */
    @GetMapping("edit")
    @ApiOperation(value="获取修改视图")
    @PreAuthorize("hasPermission('/cms/dental/edit','cms:dental:edit')")
    public ModelAndView edit(ModelAndView modelAndView,int id){
        modelAndView.addObject("dental",dentalService.selectById(id));
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
    @PreAuthorize("hasPermission('/cms/dental/edit','cms:dental:edit')")
    public Result update(@RequestBody Dental dental){
        int result = dentalService.updateById(dental);
        return decide(result);
    }

    /**
     * Describe: 用户删除接口
     * Param: id
     * Return: ResuBean
     * */
    @DeleteMapping("remove/{id}")
    @ApiOperation(value="删除数据")
    @PreAuthorize("hasPermission('/cms/dental/remove','cms:dental:remove')")
    public Result remove(@PathVariable int id){
        int result  = dentalService.deleteById(id);
        return decide(result);
    }

    /**
     * Describe: 用户批量删除接口
     * Param: ids
     * Return: ResuBean
     * */
    @DeleteMapping("batchRemove/{ids}")
    @ApiOperation(value="批量删除数据")
    @PreAuthorize("hasPermission('/cms/dental/remove','cms:dental:remove')")
    public Result batchRemove(@PathVariable String ids){
        int result = dentalService.deleteByIds(StringUtils.StringToIntArr(ids.split(",")).toArray());
        return decide(1);
    }


}
