package com.pearadmin.modules.student.domain;

import java.io.Serializable;
import java.time.LocalDate;



/**
 * 学生
 *
 * @author lwb
 * @email lwbldy@163.com
 * @date 2020-11-25 11:30:40
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

        //
    private Integer id;
        //用户名
    private String userName;
        //性别
    private Integer sex;
        //年龄
    private Integer age;
        //生日
    private LocalDate birthday;
    
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
     * 设置：用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * 获取：用户名
     */
    public String getUserName() {
        return userName;
    }
        /**
     * 设置：性别
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }
    /**
     * 获取：性别
     */
    public Integer getSex() {
        return sex;
    }
        /**
     * 设置：年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }
    /**
     * 获取：年龄
     */
    public Integer getAge() {
        return age;
    }
        /**
     * 设置：生日
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    /**
     * 获取：生日
     */
    public LocalDate getBirthday() {
        return birthday;
    }
    }