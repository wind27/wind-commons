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

    // ------------------------------- 用户 errorcode 码 -------------------------------
    /**
     * 用户手机号已注册
     */
    AUTH_USER_MOBILE_HAS_REGIST(101, "userMobileHasRegist"),

    /**
     * 用户已存在
     */
    AUTH_USER_EXISTS(102, "userExists"),

    /**
     * 用户手机号已存在
     */
    AUTH_USER_MOBILE_EXISTS(102, "userMobileExists"),

    /**
     * 用户不存在
     */
    AUTH_USER_NOT_EXISTS(103, "userNotExists"),

    /**
     * 旧密码错误
     */
    AUTH_USER_OLD_PASS_INCORRECT(10, "oldPasswordIncorrect"),

    /**
     * 找回密码或注册流程步骤顺序错误
     */
    AUTH_USER_MISTAKE_STEP(13, "mistakeStep"),

    // ------------------------------- 角色 errorcode 码 -------------------------------
    /**
     * 角色已存在
     */
    AUTH_ROLE_EXISTS(101, "roleExists"),

    /**
     * 角色不存在
     */
    AUTH_ROLE_NOT_EXISTS(103, "roleNotExists"),

    // ------------------------------- TOKEN errorcode 码 -------------------------------
    /**
     * token 失效
     */
    AUTH_TOKEN_EXPIRED(104, "tokenExpired"),

    /**
     * token 错误
     */
    AUTH_TOKEN_ERROR(105, "tokenIncorrect"),

    // ------------------------------- 菜单 errorcode 码 -------------------------------

    /**
     * 菜单URL 已存在
     */
    AUTH_MENU_URL_EXISTS(105, "menuUrlExists"),

    AUTH_MENU_NOT_EXISTS(106, "menuNotExists"),

    // ------------------------------- 权限 errorcode 码 -------------------------------

    /**
     * 权限value已存在
     */
    AUTH_PERMISSION_VALUE_EXISTS(105, "permissionValueExists"),

    /**
     * 权限不存在
     */
    AUTH_PERMISSION_NOT_EXISTS(105, "permissionNotExists"),

    // ------------------------------- 图片 errorcode 码 -------------------------------
    /**
     * 图片验证码超时
     */
    IMAGE_TIMEOUT(11, "imageTimeout"),

    /**
     * 图片验证码验证失败
     */
    IMAGE_AUTH_FAIL(12, "imageAuthFail"),

    /**
     * 图片上传失败
     */
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
