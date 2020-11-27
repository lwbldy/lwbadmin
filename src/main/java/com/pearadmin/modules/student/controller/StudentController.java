package com.pearadmin.modules.student.controller;


import com.pearadmin.modules.student.domain.Student;
import com.pearadmin.modules.student.service.IStudentService;


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
@Api(tags = "学生")
@RequestMapping("/student/student")
public class StudentController extends BaseController {

    /**
         * Describe: 基础路径
         * */
    private static String MODULE_PATH = "student/student/";


    @Resource
    private IStudentService studentService;

    @GetMapping("main")
    @ApiOperation(value="获取列表视图")
    @PreAuthorize("hasPermission('/student/student/main','student:student:main')")
    public ModelAndView main( ){
        return JumpPage(MODULE_PATH + "main");
    }


    @GetMapping("data")
    @ApiOperation(value="获取角色列表数据")
    @PreAuthorize("hasPermission('/student/student/main','student:student:main')")
    public ResultTable data(PageDomain pageDomain, Student param){
        PageInfo<Student> pageInfo = studentService.page(param,pageDomain);
        return pageTable(pageInfo.getList(),pageInfo.getTotal());
    }

    @GetMapping("add")
    @ApiOperation(value="获取新增视图")
    @PreAuthorize("hasPermission('/student/student/add','student:student:add')")
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
    @PreAuthorize("hasPermission('/student/student/add','student:student:add')")
    public Result save(@RequestBody Student student){
        int result = studentService.insert(student);
        return decide(result);
    }

    /**
     * Describe: 获取修改视图
     * Param ModelAndView
     * Return 修改视图
     * */
    @GetMapping("edit")
    @ApiOperation(value="获取修改视图")
    @PreAuthorize("hasPermission('/student/student/edit','student:student:edit')")
    public ModelAndView edit(ModelAndView modelAndView,int id){
        modelAndView.addObject("student",studentService.selectById(id));
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
    @PreAuthorize("hasPermission('/student/student/edit','student:student:edit')")
    public Result update(@RequestBody Student student){
        int result = studentService.updateById(student);
        return decide(result);
    }

    /**
     * Describe: 用户删除接口
     * Param: id
     * Return: ResuBean
     * */
    @DeleteMapping("remove/{id}")
    @ApiOperation(value="删除数据")
    @PreAuthorize("hasPermission('/student/student/remove','student:student:remove')")
    public Result remove(@PathVariable int id){
        int result  = studentService.deleteById(id);
        return decide(result);
    }

    /**
     * Describe: 用户批量删除接口
     * Param: ids
     * Return: ResuBean
     * */
    @DeleteMapping("batchRemove/{ids}")
    @ApiOperation(value="批量删除数据")
    @PreAuthorize("hasPermission('/student/student/remove','student:student:remove')")
    public Result batchRemove(@PathVariable String ids){
        int result = studentService.deleteByIds(StringUtils.StringToIntArr(ids.split(",")).toArray());
        return decide(1);
    }


}
