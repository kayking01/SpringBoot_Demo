package com.shirodemo.kay.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 用户登录表
 * @TableName sys_user_login_log
 */
@TableName(value ="sys_user_login_log")
@Data
public class UserLoginLog implements Serializable {
    /**
     * 登录日志ID
     */
    @TableId(type = IdType.AUTO)
    private Long logId;

    /**
     * 登录时间
     */
    private Integer loginTime;

    /**
     * 登录IP
     */
    private String loginIp;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 操作系统
     */
    private String operatingSystem;

    /**
     * 浏览器
     */
    private String browser;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}