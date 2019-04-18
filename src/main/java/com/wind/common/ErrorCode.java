package com.wind.common;

/**
 * ErrorCode
 *
 * @author qianchun 17/7/13
 **/
public enum ErrorCode {

    /**
     * 成功
     */
    SUCCESS(0, "success"),

    /**
     * 失败
     */
    FAIL(1, "fail"),


    /**
     * 系统异常
     */
    SYS_ERROR(2, "sys_error"),

    /**
     * 参数错误
     */
    PARAM_ERROR(3, "param_error"),

    /**
     * 没有操作权限
     */
    NO_PREMISSION(4, "no_premission"),


    /**
     * 不存在
     */
    NOT_EXISTS(5, "not_exists"),

    /**
     * 已存在
     */
    EXISTS(6, "exists"),

    /**
     * 已禁用
     */
    DISABLED(7, "disabled"),

    /**
     * 超过访问次数
     */
    OVER_ACCESS_TIMES(8, "over_access_times"),

    /**
     * 未登录
     */
    NO_LOGIN(9, "no_login"),

    //------------------------------- 用户 errorcode 码 -------------------------------
    /**
     * 用户手机号已注册
     */
    USER_MOBILE_HAS_REGIST(101, "userMobileHasRegist"),

    /**
     * 用户已存在
     */
    USER_EXISTS(102, "userExists"),

    /**
     * 角色已存在
     */
    ROLE_HAS_EXISTS(101, "userMobileHasRegist"),

    /**
     * 用户不存在
     */
    USER_NOT_EXISTS(103, "userNotExists"),

    /**
     * 角色不存在
     */
    ROLE_NOT_EXISTS(103, "roleNotExists"),

    /**
     * token 失效
     */
    TOKEN_EXPIRED(104, "tokenExpired"),

    /**
     * token 错误
     */
    TOKEN_ERROR(105, "tokenIncorrect"),

    /**
     * 菜单URL 已存在
     */
    MENU_URL_HAS_EXISTS(105, "menuUrlHasExists"),

    //------------------------------- 图片 errorcode 码 -------------------------------
    FILE_UPLOAD_ERROR(201, "文件上传失败");


    private Integer value;

    private String name;

    ErrorCode(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
