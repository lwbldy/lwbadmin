package com.pearadmin.modules.cms.domain;

import java.io.Serializable;
import java.time.LocalDate;



/**
 * 医生
 *
 * @author lwb
 * @email lwbldy@163.com
 * @date 2020-12-14 16:18:04
 */
public class DoctorResource implements Serializable {
    private static final long serialVersionUID = 1L;

        //
    private Integer id;
        //姓名
    private String username;
        //职位
    private String job;
        //学位
    private String degree;
        //毕业学校
    private String school;
        //所在诊所
    private Integer clinic;
        //出诊时间
    private String visitTime;
        //头像
    private String pic;
        //擅长
    private String good;
        //年龄
    private String age;
        //资历
    private String seniority;
        //医院经历
    private String clinicSeniority;
        //更多
    private String outher;
        //创建时间
    private LocalDate createTime;
    
        /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }
        /**
     * 设置：姓名
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * 获取：姓名
     */
    public String getUsername() {
        return username;
    }
        /**
     * 设置：职位
     */
    public void setJob(String job) {
        this.job = job;
    }
    /**
     * 获取：职位
     */
    public String getJob() {
        return job;
    }
        /**
     * 设置：学位
     */
    public void setDegree(String degree) {
        this.degree = degree;
    }
    /**
     * 获取：学位
     */
    public String getDegree() {
        return degree;
    }
        /**
     * 设置：毕业学校
     */
    public void setSchool(String school) {
        this.school = school;
    }
    /**
     * 获取：毕业学校
     */
    public String getSchool() {
        return school;
    }
        /**
     * 设置：所在诊所
     */
    public void setClinic(Integer clinic) {
        this.clinic = clinic;
    }
    /**
     * 获取：所在诊所
     */
    public Integer getClinic() {
        return clinic;
    }
        /**
     * 设置：出诊时间
     */
    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }
    /**
     * 获取：出诊时间
     */
    public String getVisitTime() {
        return visitTime;
    }
        /**
     * 设置：头像
     */
    public void setPic(String pic) {
        this.pic = pic;
    }
    /**
     * 获取：头像
     */
    public String getPic() {
        return pic;
    }
        /**
     * 设置：擅长
     */
    public void setGood(String good) {
        this.good = good;
    }
    /**
     * 获取：擅长
     */
    public String getGood() {
        return good;
    }
        /**
     * 设置：年龄
     */
    public void setAge(String age) {
        this.age = age;
    }
    /**
     * 获取：年龄
     */
    public String getAge() {
        return age;
    }
        /**
     * 设置：资历
     */
    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }
    /**
     * 获取：资历
     */
    public String getSeniority() {
        return seniority;
    }
        /**
     * 设置：医院经历
     */
    public void setClinicSeniority(String clinicSeniority) {
        this.clinicSeniority = clinicSeniority;
    }
    /**
     * 获取：医院经历
     */
    public String getClinicSeniority() {
        return clinicSeniority;
    }
        /**
     * 设置：更多
     */
    public void setOuther(String outher) {
        this.outher = outher;
    }
    /**
     * 获取：更多
     */
    public String getOuther() {
        return outher;
    }
        /**
     * 设置：创建时间
     */
    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }
    /**
     * 获取：创建时间
     */
    public LocalDate getCreateTime() {
        return createTime;
    }
    }