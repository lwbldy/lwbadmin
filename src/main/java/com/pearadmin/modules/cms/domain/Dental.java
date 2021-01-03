package com.pearadmin.modules.cms.domain;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


/**
 * 牙齿文章
 *
 * @author lwb
 * @email lwbldy@163.com
 * @date 2020-12-22 14:00:42
 */
public class Dental implements Serializable {
    private static final long serialVersionUID = 1L;

        //
    private Integer id;
        //标题
    private String title;
        //类型id
    private String typeId;
        //主图
    private String pic;
        //摘要
    private String synopsis;
        //创建时间
    private Date creatTime;
        //显示时间
    private LocalDate showTime;
        //详细内容
    private String context;

    private String typeName;

    /**
     * 点击次数
     */
    private Integer hits;


    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

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
     * 设置：类型id
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
    /**
     * 获取：类型id
     */
    public String getTypeId() {
        return typeId;
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
     * 设置：摘要
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    /**
     * 获取：摘要
     */
    public String getSynopsis() {
        return synopsis;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
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

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }
}