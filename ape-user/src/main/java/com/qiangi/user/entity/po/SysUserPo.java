package com.qiangi.user.entity.po;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户表(SysUserPo)实体类
 *
 * @author qiangi
 * @since 2025-05-11 19:31:17
 */
public class SysUserPo implements Serializable {
    private static final long serialVersionUID = -40303279314782325L;
/**
     * 主键ID
     */
    private Long id;
/**
     * 名称
     */
    private String name;
/**
     * 年龄
     */
    private Integer age;
/**
     * 创建人
     */
    private String createBy;
/**
     * 创建时间
     */
    private Date createTime;
/**
     * 更新人
     */
    private String updateBy;
/**
     * 更新时间
     */
    private Date updateTime;
/**
     * 删除标志 0-未删除 1-已删除
     */
    private Integer deleteFlag;
/**
     * 版本号（用于乐观锁）
     */
    private Integer version;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}


