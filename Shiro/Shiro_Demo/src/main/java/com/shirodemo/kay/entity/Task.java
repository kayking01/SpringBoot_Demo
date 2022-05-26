package com.shirodemo.kay.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 平台_定时任务
 * @TableName sys_task
 */
@TableName(value ="sys_task")
@Data
public class Task implements Serializable {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 执行时间
     */
    private String cronExpression;

    /**
     * 任务名称
     */
    private String jobName;

    /**
     * 业务模块
     */
    private String bizModule;

    /**
     * 业务id
     */
    private String bizId;

    /**
     * 业务标识
     */
    private String bizTag;

    /**
     * 回调内容
     */
    private String callbackData;

    /**
     * 回调类型(PRINT/CLASS/HTTP/HESSIAN)
     */
    private String callbackType;

    /**
     * 回调地址
     */
    private String callbackUrl;

    /**
     * 是否有效
     */
    private Integer enabled;

    /**
     * 创建时间
     */
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}