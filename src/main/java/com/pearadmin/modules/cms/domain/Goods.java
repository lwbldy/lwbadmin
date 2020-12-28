package com.pearadmin.modules.cms.domain;

import java.io.Serializable;
import java.time.LocalDate;



/**
 * 积分兑换
 *
 * @author lwb
 * @email lwbldy@163.com
 * @date 2020-12-27 10:47:46
 */
public class Goods implements Serializable {
    private static final long serialVersionUID = 1L;

        //
    private Integer id;
        //标题
    private String title;
        //主图
    private String pic;
        //简介
    private String synopsis;
        //状态
    private Integer status;
        //详细内容
    private String context;
    
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
    }