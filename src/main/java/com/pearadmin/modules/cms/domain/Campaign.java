package com.pearadmin.modules.cms.domain;

import java.io.Serializable;
import java.time.LocalDate;



/**
 * 活动宣传
 *
 * @author lwb
 * @email lwbldy@163.com
 * @date 2021-01-05 11:09:51
 */
public class Campaign implements Serializable {
    private static final long serialVersionUID = 1L;

        //
    private Integer id;
        //标题
    private String title;
        //主图
    private String pic;
        //简介
    private String synopsis;
        //活动时间
    private String visitTime;
        //活动地址
    private String visitAddress;
        //状态
    private Integer status;
        //详细内容
    private String context;
    // 排序
    private Integer sort;
    
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
     * 设置：活动时间
     */
    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }
    /**
     * 获取：活动时间
     */
    public String getVisitTime() {
        return visitTime;
    }
        /**
     * 设置：活动地址
     */
    public void setVisitAddress(String visitAddress) {
        this.visitAddress = visitAddress;
    }
    /**
     * 获取：活动地址
     */
    public String getVisitAddress() {
        return visitAddress;
    }
        /**
     * 设置：状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
    /**
     * 获取：状态
     */
    public Integer getStatus() {
        return status;
    }
        /**
     * 设置：详细内容
     */
    public void setContext(String context) {
        this.context = context;
    }
    /**
     * 获取：详细内容
     */
    public String getContext() {
        return context;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}