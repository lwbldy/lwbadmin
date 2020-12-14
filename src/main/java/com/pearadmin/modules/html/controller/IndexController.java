package com.pearadmin.modules.html.controller;

import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.modules.cms.domain.Clinic;
import com.pearadmin.modules.cms.domain.DoctorResource;
import com.pearadmin.modules.cms.service.IClinicService;
import com.pearadmin.modules.cms.service.IDoctorResourceService;
import com.pearadmin.modules.system.domain.SysDictData;
import com.pearadmin.modules.system.service.ISysDictDataService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@RestController
@Api(tags = "医院信息")
public class IndexController extends BaseController {

    @Resource
    private IClinicService clinicService;
    @Resource
    private ISysDictDataService sysDictDataService;
    @Resource
    private IDoctorResourceService doctorResourceService;


    @RequestMapping("/")
    public ModelAndView index(){
        return JumpPage(  "home");
    }

    @GetMapping("html/clinic")
    public ModelAndView Clinic(ModelAndView modelAndView, PageDomain pageDomain, Clinic param){

        if(pageDomain.getPage() == null){
            pageDomain.setPage(1);
        }
        if(pageDomain.getLimit() == null){
            pageDomain.setLimit(9);
        }

        PageInfo<Clinic> pageInfo = clinicService.page(param,pageDomain);
        modelAndView.addObject("pageInfo",pageInfo);


        SysDictData sysDictData = new SysDictData();
        sysDictData.setTypeCode("region");
        modelAndView.addObject("regionList",sysDictDataService.list(sysDictData));

        modelAndView.addObject("param",param);

        modelAndView.setViewName("html/clinic/index");

        return modelAndView;
    }

    @GetMapping("html/doctor")
    public ModelAndView doctor(ModelAndView modelAndView, PageDomain pageDomain, DoctorResource param){

        if(pageDomain.getPage() == null){
            pageDomain.setPage(1);
        }
        if(pageDomain.getLimit() == null){
            pageDomain.setLimit(9);
        }

        PageInfo<DoctorResource> pageInfo = doctorResourceService.page(param,pageDomain);
        modelAndView.addObject("pageInfo",pageInfo);


        modelAndView.addObject("param",param);

        modelAndView.setViewName("html/clinic/index");

        return modelAndView;
    }

}
