package com.qiangi.user.service;

import com.qiangi.user.entity.po.SysUserPo;

import java.util.List;

/**
 * 用户表(SysUserPo)表服务接口
 *
 * @author qiangi
 * @since 2025-05-11 19:31:17
 */
public interface SysUserService {

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    List<SysUserPo> queryAll();
    
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUserPo queryById(Long id);

    /**
     * 新增数据
     *
     * @param sysUserPo 实例对象
     * @return 实例对象
     */
    SysUserPo insert(SysUserPo sysUserPo);

    /**
     * 修改数据
     *
     * @param sysUserPo 实例对象
     * @return 实例对象
     */
    SysUserPo update(SysUserPo sysUserPo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
