package com.pearadmin.modules.test.domain;

import java.io.Serializable;
import java.time.LocalDate;



/**
 * 
 *
 * @author lwb
 * @email lwbldy@163.com
 * @date 2020-11-19 20:57:16
 */
public class TestTable implements Serializable {
    private static final long serialVersionUID = 1L;

        //
    private Integer id;
        //姓名
    private String name;
        //IP
    private String ip;
        //添加时间
    private String addTime;
    
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
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 获取：姓名
     */
    public String getName() {
        return name;
    }
        /**
     * 设置：IP
     */
    public void setIp(String ip) {
        this.ip = ip;
    }
    /**
     * 获取：IP
     */
    public String getIp() {
        return ip;
    }
        /**
     * 设置：添加时间
     */
    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }
    /**
     * 获取：添加时间
     */
    public String getAddTime() {
        return addTime;
    }
    }