package com.spring.base.model.user;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author hinzzz
 * @since 2019-10-14
 */
public class BlogMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 父菜单ID
     */
    private Integer parentId;
    /**
     * 菜单编码
     */
    private String menuCode;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 菜单路径
     */
    private String menuUrl;
    /**
     * 权限ID
     */
    private String rigthId;
    /**
     * 菜单等级
     */
    private Integer menuLevel;
    /**
     * 菜单类型 0：功能 1：菜单
     */
    private String menuType;
    /**
     * 排序
     */
    private String orderNo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getRigthId() {
        return rigthId;
    }

    public void setRigthId(String rigthId) {
        this.rigthId = rigthId;
    }

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public String toString() {
        return "BlogMenu{" +
        ", id=" + id +
        ", parentId=" + parentId +
        ", menuCode=" + menuCode +
        ", menuName=" + menuName +
        ", menuUrl=" + menuUrl +
        ", rigthId=" + rigthId +
        ", menuLevel=" + menuLevel +
        ", menuType=" + menuType +
        ", orderNo=" + orderNo +
        "}";
    }
}
