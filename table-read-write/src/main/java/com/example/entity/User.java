package com.example.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author qingshun.meng
 * @ClassName User
 * @description: TODO
 * @date 2025年10月02日
 * @version: 1.0
 */
@Data
public class User {
    /**
     * 主键
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private Date updateTime;

    /**
     * 是否删除 1删除 0未删除
     */
    private Integer status;

}
