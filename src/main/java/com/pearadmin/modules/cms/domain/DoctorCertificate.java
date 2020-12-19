package com.pearadmin.modules.cms.domain;

import java.io.Serializable;
import java.time.LocalDate;



/**
 * 医生证书
 *
 * @author lwb
 * @email lwbldy@163.com
 * @date 2020-12-18 11:33:11
 */
public class DoctorCertificate implements Serializable {
    private static final long serialVersionUID = 1L;

        //
    private Integer id;
        //医生id
    private Integer doctorId;
        //图片编号
    private String picId;
    //证书标题
    private String title;
    
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
     * 设置：医生id
     */
    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }
    /**
     * 获取：医生id
     */
    public Integer getDoctorId() {
        return doctorId;
    }
        /**
     * 设置：图片编号
     */
    public void setPicId(String picId) {
        this.picId = picId;
    }
    /**
     * 获取：图片编号
     */
    public String getPicId() {
        return picId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}