package com.spring.sys.log;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ：quanhz
 * @date ：Created in 2019/9/18 9:24
 *
 */
public class BaseOperLog implements Serializable {
    private Long id;
    //操作人
    private String userName;
    //菜单code
    private String menuCode;
    //菜单名称
    private String menuName;
    //菜单id
    private Integer menuId;
    //父菜单id
    private Integer parentMenuId;
    //请求方法
    private String requestMethod;
    //请求参数
    private String requestParams;
    //请求返回结果
    private String returnResult;
    //请求ip
    private String requestIp;
    //请求时间
    private Date requestTime;
    //请求开始时间
    private Date requestBeginTime;
    //请求结束时间
    private Date requestEndTime;


    //方法描述
    private String methodDesc;
    //请求状态 0 失败 1 成功
    private Integer requestStatus;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams;
    }

    public String getReturnResult() {
        return returnResult;
    }

    public void setReturnResult(String returnResult) {
        this.returnResult = returnResult;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    public String getMethodDesc() {
        return methodDesc;
    }

    public void setMethodDesc(String methodDesc) {
        this.methodDesc = methodDesc;
    }

    public Integer getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(Integer requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(Integer parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Date getRequestBeginTime() {
        return requestBeginTime;
    }

    public void setRequestBeginTime(Date requestBeginTime) {
        this.requestBeginTime = requestBeginTime;
    }

    public Date getRequestEndTime() {
        return requestEndTime;
    }

    public void setRequestEndTime(Date requestEndTime) {
        this.requestEndTime = requestEndTime;
    }

    @Override
    public String toString() {
        return "BaseOperLog{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", menuCode='" + menuCode + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuId=" + menuId +
                ", parentMenuId=" + parentMenuId +
                ", requestMethod='" + requestMethod + '\'' +
                ", requestParams='" + requestParams + '\'' +
                ", returnResult='" + returnResult + '\'' +
                ", requestIp='" + requestIp + '\'' +
                ", requestTime=" + requestTime +
                ", requestBeginTime=" + requestBeginTime +
                ", requestEndTime=" + requestEndTime +
                ", methodDesc='" + methodDesc + '\'' +
                ", requestStatus=" + requestStatus +
                '}';
    }
}
