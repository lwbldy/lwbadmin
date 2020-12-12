package com.pearadmin.modules.cms.domain;

import java.io.Serializable;
import java.time.LocalDate;



/**
 * 医院信息
 *
 * @author lwb
 * @email lwbldy@163.com
 * @date 2020-12-10 10:45:34
 */
public class Clinic implements Serializable {
    private static final long serialVersionUID = 1L;

        //
    private Integer id;
        //名称
    private String clinicName;
        //电话
    private String telephone;
        //地址
    private String address;
        //地图信息
    private String map;
        //营业时间
    private String openingHours;
        //简介
    private String details;
        //地区
    private String region;
    // 主图
    private String pic;
    
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
     * 设置：名称
     */
    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }
    /**
     * 获取：名称
     */
    public String getClinicName() {
        return clinicName;
    }
        /**
     * 设置：电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    /**
     * 获取：电话
     */
    public String getTelephone() {
        return telephone;
    }
        /**
     * 设置：地址
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * 获取：地址
     */
    public String getAddress() {
        return address;
    }
        /**
     * 设置：地图信息
     */
    public void setMap(String map) {
        this.map = map;
    }
    /**
     * 获取：地图信息
     */
    public String getMap() {
        return map;
    }
        /**
     * 设置：营业时间
     */
    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }
    /**
     * 获取：营业时间
     */
    public String getOpeningHours() {
        return openingHours;
    }
        /**
     * 设置：简介
     */
    public void setDetails(String details) {
        this.details = details;
    }
    /**
     * 获取：简介
     */
    public String getDetails() {
        return details;
    }
        /**
     * 设置：地区
     */
    public void setRegion(String region) {
        this.region = region;
    }
    /**
     * 获取：地区
     */
    public String getRegion() {
        return region;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}