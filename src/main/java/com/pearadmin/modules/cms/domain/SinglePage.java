package com.pearadmin.modules.cms.domain;

import java.io.Serializable;
import java.time.LocalDate;



/**
 * 单页
 *
 * @author lwb
 * @email lwbldy@163.com
 * @date 2020-12-25 14:09:35
 */
public class SinglePage implements Serializable {
    private static final long serialVersionUID = 1L;

        //
    private Integer id;
        //标题
    private String title;
        //类型
    private String typeId;
        //url
    private String url;
        //简介
    private String synopsis;
        //内容
    private String context;
        //主图
    private String pic;
        //显示时间
    private LocalDate showTime;
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
     * 设置：标题
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * 获取：标题
     */
    public String getTitle() {
        return title;
    }
        /**
     * 设置：类型
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
    /**
     * 获取：类型
     */
    public String getTypeId() {
        return typeId;
    }
        /**
     * 设置：url
     */
    public void setUrl(String url) {
        this.url = url;
    }
    /**
     * 获取：url
     */
    public String getUrl() {
        return url;
    }
        /**
     * 设置：简介
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    /**
     * 获取：简介
     */
    public String getSynopsis() {
        return synopsis;
    }
        /**
     * 设置：内容
     */
    public void setContext(String context) {
        this.context = context;
    }
    /**
     * 获取：内容
     */
    public String getContext() {
        return context;
    }
        /**
     * 设置：主图
     */
    public void setPic(String pic) {
        this.pic = pic;
    }
    /**
     * 获取：主图
     */
    public String getPic() {
        return pic;
    }
        /**
     * 设置：显示时间
     */
    public void setShowTime(LocalDate showTime) {
        this.showTime = showTime;
    }
    /**
     * 获取：显示时间
     */
    public LocalDate getShowTime() {
        return showTime;
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