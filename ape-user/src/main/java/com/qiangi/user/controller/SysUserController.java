package com.qiangi.user.controller;

import com.qiangi.bean.Result;
import com.qiangi.user.entity.po.SysUserPo;
import com.qiangi.user.service.SysUserService;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.annotation.Resource;

/**
 * 用户表(SysUserPo)表控制层
 *
 * @author qiangi
 * @since 2025-05-11 19:31:17
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    @GetMapping
    public Result<List> queryAll() {
        return Result.ok(this.sysUserService.queryAll());
    }
    
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @Cacheable(cacheNames = "sysUser",key = "'querySysUserById'+#id")
    public Result<SysUserPo> queryById(@PathVariable("id") Long id) {
        return Result.ok(this.sysUserService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param sysUserPo 实体
     * @return 新增结果
     */
    @PostMapping
    public Result<SysUserPo> add(SysUserPo sysUserPo) {
        return Result.ok(this.sysUserService.insert(sysUserPo));
    }

    /**
     * 编辑数据
     *
     * @param sysUserPo 实体
     * @return 编辑结果
     */
    @PutMapping
    public Result<SysUserPo> edit(SysUserPo sysUserPo) {
        return Result.ok(this.sysUserService.update(sysUserPo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public Result<Boolean> deleteById(Long id) {
        return Result.ok(this.sysUserService.deleteById(id));
    }

}
