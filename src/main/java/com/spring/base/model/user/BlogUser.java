package com.spring.base.model.user;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author hinzzz
 * @since 2019-10-14
 */
public class BlogUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户唯一标识
     */
    private String userName;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 电话
     */
    private String telNo;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 用户状态，0-无效，1-有效
     */
    private Integer status;
    /**
     * 用户样式主题
     */
    private String theme;
    /**
     * 创建人
     */
    private String createOperator;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改密码时间
     */
    private Date lastUpdateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getCreateOperator() {
        return createOperator;
    }

    public void setCreateOperator(String createOperator) {
        this.createOperator = createOperator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public String toString() {
        return "BlogUser{" +
        ", id=" + id +
        ", userName=" + userName +
        ", password=" + password +
        ", realName=" + realName +
        ", telNo=" + telNo +
        ", email=" + email +
        ", status=" + status +
        ", theme=" + theme +
        ", createOperator=" + createOperator +
        ", createTime=" + createTime +
        ", lastUpdateTime=" + lastUpdateTime +
        "}";
    }
}
