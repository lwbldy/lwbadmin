package com.pearadmin.modules.cms.controller;


import com.pearadmin.modules.cms.domain.Campaign;
import com.pearadmin.modules.cms.service.ICampaignService;


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
@Api(tags = "活动宣传")
@RequestMapping("/cms/campaign")
public class CampaignController extends BaseController {

    /**
         * Describe: 基础路径
         * */
    private static String MODULE_PATH = "cms/campaign/";


    @Resource
    private ICampaignService campaignService;

    @GetMapping("main")
    @ApiOperation(value="获取列表视图")
    @PreAuthorize("hasPermission('/cms/campaign/main','cms:campaign:main')")
    public ModelAndView main( ){
        return JumpPage(MODULE_PATH + "main");
    }


    @GetMapping("data")
    @ApiOperation(value="获取角色列表数据")
    @PreAuthorize("hasPermission('/cms/campaign/main','cms:campaign:main')")
    public ResultTable data(PageDomain pageDomain, Campaign param){
        PageInfo<Campaign> pageInfo = campaignService.page(param,pageDomain);
        return pageTable(pageInfo.getList(),pageInfo.getTotal());
    }

    @GetMapping("add")
    @ApiOperation(value="获取新增视图")
    @PreAuthorize("hasPermission('/cms/campaign/add','cms:campaign:add')")
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
    @PreAuthorize("hasPermission('/cms/campaign/add','cms:campaign:add')")
    public Result save(@RequestBody Campaign campaign){
        int result = campaignService.insert(campaign);
        return decide(result);
    }

    /**
     * Describe: 获取修改视图
     * Param ModelAndView
     * Return 修改视图
     * */
    @GetMapping("edit")
    @ApiOperation(value="获取修改视图")
    @PreAuthorize("hasPermission('/cms/campaign/edit','cms:campaign:edit')")
    public ModelAndView edit(ModelAndView modelAndView,int id){
        modelAndView.addObject("campaign",campaignService.selectById(id));
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
    @PreAuthorize("hasPermission('/cms/campaign/edit','cms:campaign:edit')")
    public Result update(@RequestBody Campaign campaign){
        int result = campaignService.updateById(campaign);
        return decide(result);
    }

    /**
     * Describe: 用户删除接口
     * Param: id
     * Return: ResuBean
     * */
    @DeleteMapping("remove/{id}")
    @ApiOperation(value="删除数据")
    @PreAuthorize("hasPermission('/cms/campaign/remove','cms:campaign:remove')")
    public Result remove(@PathVariable int id){
        int result  = campaignService.deleteById(id);
        return decide(result);
    }

    /**
     * Describe: 用户批量删除接口
     * Param: ids
     * Return: ResuBean
     * */
    @DeleteMapping("batchRemove/{ids}")
    @ApiOperation(value="批量删除数据")
    @PreAuthorize("hasPermission('/cms/campaign/remove','cms:campaign:remove')")
    public Result batchRemove(@PathVariable String ids){
        int result = campaignService.deleteByIds(StringUtils.StringToIntArr(ids.split(",")).toArray());
        return decide(1);
    }


}
