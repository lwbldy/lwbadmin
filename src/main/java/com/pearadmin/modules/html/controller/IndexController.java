package com.pearadmin.modules.html.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.plugins.resource.service.IFileService;
import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.modules.cms.domain.*;
import com.pearadmin.modules.cms.service.*;
import com.pearadmin.modules.system.domain.SysDictData;
import com.pearadmin.modules.system.service.ISysDictDataService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@Api(tags = "医院信息")
public class IndexController extends BaseController {

    @Resource
    private IClinicService clinicService;
    @Resource
    private ISysDictDataService sysDictDataService;
    @Resource
    private IDoctorResourceService doctorResourceService;
    @Resource
    private IDoctorCertificateService doctorCertificateService;
    @Resource
    private IDentalService dentalService;
    @Resource
    private ISinglePageService singlePageService;
    @Resource
    private IUsersService usersService;
    @Resource
    private IGoodsService goodsService;
    @Resource
    private ICampaignService campaignService;


    @RequestMapping("/")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.addObject("doctorCount",doctorResourceService.selectAllCount());
        SysDictData sysDictData = new SysDictData();
        sysDictData.setTypeCode("region");
        modelAndView.addObject("regionList",sysDictDataService.list(sysDictData));
        modelAndView.setViewName("home");
        return modelAndView;
    }

    /**
     * 寻找诊所
     * @param modelAndView
     * @param pageDomain
     * @param param
     * @return
     */
    @GetMapping("html/clinic")
    public ModelAndView clinic(ModelAndView modelAndView, PageDomain pageDomain, Clinic param){

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


        String mark = "";
        for(int i = 0;i<pageInfo.getList().size();i++){
            Clinic cl = pageInfo.getList().get(i);
            mark = mark + cl.getMap()+","+ cl.getClinicName();
            if(i!=pageInfo.getList().size()-1){
                mark+="|";
            }
        }
        try{
            mark = java.net.URLEncoder.encode(mark, "UTF-8");
        }catch(Exception e){
            e.printStackTrace();
        }
        String mapURL = "https://uri.amap.com/marker?markers="+mark+"&src=mypage&callnative=0";
        modelAndView.addObject("mapURL",mapURL);
        modelAndView.addObject("param",param);
        modelAndView.setViewName("html/clinic/index");
        return modelAndView;
    }


    /**
     * 医生资源详情
     * @param id
     * @param modelAndView
     * @return
     */
    @GetMapping("html/clinic/details")
    public ModelAndView clinicDetils(int id,ModelAndView modelAndView){

        Clinic clinic = clinicService.selectById(id);

        modelAndView.addObject("clinic",clinic);

        DoctorResource doctorResource = new DoctorResource();
        doctorResource.setClinic(clinic.getId());

        String name = "";

        try{
            name = java.net.URLEncoder.encode(clinic.getClinicName(), "UTF-8");
        }catch(Exception e){
            e.printStackTrace();
        }
        String mapURL = "https://uri.amap.com/marker?position="+clinic.getMap()+"&name="+name+"&src=mypage&coordinate=gaode&callnative=0";
        modelAndView.addObject("mapURL",mapURL);
        List<DoctorResource> doctorList = doctorResourceService.selectList(doctorResource);
        modelAndView.addObject("doctorList",doctorList);



        modelAndView.setViewName("html/clinic/details");
        return modelAndView;
    }




    /**
     * 获取医生资源
     * @param modelAndView
     * @param pageDomain
     * @param param
     * @return
     */
    @GetMapping("html/doctor")
    public ModelAndView doctor(ModelAndView modelAndView, PageDomain pageDomain, DoctorResource param){

        if(pageDomain.getPage() == null){
            pageDomain.setPage(1);
        }
        if(pageDomain.getLimit() == null){
            pageDomain.setLimit(5);
        }

        PageInfo<DoctorResource> pageInfo = doctorResourceService.page(param,pageDomain);
        modelAndView.addObject("pageInfo",pageInfo);

        SysDictData sysDictData = new SysDictData();
        sysDictData.setTypeCode("region");
        modelAndView.addObject("regionList",sysDictDataService.list(sysDictData));


        modelAndView.addObject("param",param);
        modelAndView.setViewName("html/doctor/index");
        return modelAndView;
    }


    /**
     * 医生资源详情
     * @param id
     * @param modelAndView
     * @return
     */
    @GetMapping("html/doctor/details")
    public ModelAndView doctorDetils(int id,ModelAndView modelAndView){
        modelAndView.addObject("doctor",doctorResourceService.selectById(id));

        DoctorCertificate doctorCertificate = new DoctorCertificate();
        doctorCertificate.setDoctorId(id);
        //证书列表
        List<DoctorCertificate> certificateList =  doctorCertificateService.selectList(doctorCertificate);
        modelAndView.addObject("certificateList",certificateList);
        modelAndView.setViewName("html/doctor/detils");
        return modelAndView;
    }

    /**
     * 医生和技术委员会列表
     * @param modelAndView
     * @param pageDomain
     * @param param
     * @return
     */
    @GetMapping("html/committee")
    public ModelAndView committee(ModelAndView modelAndView, PageDomain pageDomain, DoctorResource param){
        if(pageDomain.getLimit() == null){
            pageDomain.setLimit(5);
        }

        if(pageDomain.getPage() == null){
            pageDomain.setPage(1);
        }

        PageInfo<DoctorResource> pageInfo = doctorResourceService.page2(param,pageDomain);
        modelAndView.addObject("pageInfo",pageInfo);

        System.out.println(JSON.toJSONString(pageInfo));

        modelAndView.addObject("param",param);
        modelAndView.setViewName("html/committee/index");
        return modelAndView;
    }

    @GetMapping("html/dental")
    public ModelAndView dental(ModelAndView modelAndView, PageDomain pageDomain, Dental param){
        if(pageDomain.getPage() == null){
            pageDomain.setPage(1);
        }
        if(pageDomain.getLimit() == null){
            pageDomain.setLimit(9);
        }
        PageInfo<Dental> pageInfo = dentalService.page(param,pageDomain);
        modelAndView.addObject("pageInfo",pageInfo);
        SysDictData sysDictData = new SysDictData();
        sysDictData.setTypeCode("ybkp");
        modelAndView.addObject("typeList",sysDictDataService.list(sysDictData));
        modelAndView.addObject("param",param);
        modelAndView.setViewName("html/dental/index");
        return modelAndView;
    }

    /**
     * 文章详情
     * @param id
     * @param modelAndView
     * @return
     */
    @GetMapping("html/dental/details")
    public ModelAndView dentalDdetails(int id,ModelAndView modelAndView){
        Dental dental = dentalService.selectById(id);
        modelAndView.addObject("dental",dental);
        modelAndView.setViewName("html/dental/detils");
        return modelAndView;
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("html/dental/update/hits")
    public Result updateDentalHits(int id){
        dentalService.updateHits(id);
        return success("sucess");
    }

    /**
     * 关于我们
     * @return
     */
    @GetMapping("html/about")
    public ModelAndView about(ModelAndView modelAndView){
        modelAndView.addObject("singlePage",singlePageService.selectByURL("about"));
        modelAndView.setViewName("html/page/about");
        return modelAndView;
    }

    @GetMapping("html/page/{url}")
    public ModelAndView pageDetils(@PathVariable("url") String url,ModelAndView modelAndView){

        modelAndView.addObject("singlePage",singlePageService.selectByURL(url));

        modelAndView.setViewName("html/page/detils");
        return modelAndView;
    }


    @GetMapping("html/login")
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("html/user/login");
        return modelAndView;
    }


    @PostMapping("html/login")
    public Result login(Users users, HttpSession session){
        Users users1 = usersService.selectByUserName(users.getUserName());

        if(users1 == null){
            return failure("用户不存在");
        }

        if(!users1.getPassword().trim().equals(users.getPassword().trim())){
            return failure("密码错误");
        }

        session.setAttribute("users",users);

        return success("登录成功");
    }


    @GetMapping("html/campign")
    public ModelAndView campign(ModelAndView modelAndView, PageDomain pageDomain, Campaign param,HttpSession session){
        if(pageDomain.getPage() == null){
            pageDomain.setPage(1);
        }
        if(pageDomain.getLimit() == null){
            pageDomain.setLimit(9);
        }
        PageInfo<Campaign> pageInfo = campaignService.page(param,pageDomain);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.addObject("param",param);

        modelAndView.setViewName("html/campign/index");
        return modelAndView;
    }

    @GetMapping("html/campign/details")
    public ModelAndView campign(int id,ModelAndView modelAndView,HttpSession session){
        modelAndView.addObject("campign",campaignService.selectById(id));
        modelAndView.setViewName("html/campign/details");
        return modelAndView;
    }


    @GetMapping("html/goods")
    public ModelAndView goods(ModelAndView modelAndView, PageDomain pageDomain, Goods param,HttpSession session){

        Users users = (Users)session.getAttribute("users");
        if(users == null){
            modelAndView.setViewName("redirect:/html/login");
            return modelAndView;
        }

        if(pageDomain.getPage() == null){
            pageDomain.setPage(1);
        }
        if(pageDomain.getLimit() == null){
            pageDomain.setLimit(9);
        }
        PageInfo<Goods> pageInfo = goodsService.page(param,pageDomain);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.addObject("param",param);

        modelAndView.setViewName("html/goods/index");
        return modelAndView;
    }

    @GetMapping("html/goods/details")
    public ModelAndView Ddetails(int id,ModelAndView modelAndView,HttpSession session){

        Users users = (Users)session.getAttribute("users");
        if(users == null){
            modelAndView.setViewName("redirect:/html/login");
            return modelAndView;
        }

        modelAndView.addObject("goods",goodsService.selectById(id));

        modelAndView.setViewName("html/goods/details");
        return modelAndView;
    }


    @GetMapping("html/mv")
    public ModelAndView mv(ModelAndView modelAndView){
        modelAndView.setViewName("html/mv/index");
        return modelAndView;
    }





    /**
     * 图片详情
     */
    @Resource
    private IFileService fileService;
    @GetMapping("html/file/download/{id}")
    public void download(@PathVariable("id") String id){
        fileService.download(id);
    }


}
