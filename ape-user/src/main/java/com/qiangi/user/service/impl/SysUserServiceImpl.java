package com.qiangi.user.service.impl;

import com.qiangi.user.entity.po.SysUserPo;
import com.qiangi.user.mapper.SysUserMapper;
import com.qiangi.user.service.SysUserService;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.annotation.Resource;

/**
 * 用户表(SysUserPo)表服务实现类
 *
 * @author qiangi
 * @since 2025-05-11 19:31:17
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    @Override
    public List<SysUserPo> queryAll() {
        return this.sysUserMapper.queryAll();
    }
    
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUserPo queryById(Long id) {
        return this.sysUserMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param sysUserPo 实例对象
     * @return 实例对象
     */
    @Override
    public SysUserPo insert(SysUserPo sysUserPo) {
        this.sysUserMapper.insert(sysUserPo);
        return sysUserPo;
    }

    /**
     * 修改数据
     *
     * @param sysUserPo 实例对象
     * @return 实例对象
     */
    @Override
    public SysUserPo update(SysUserPo sysUserPo) {
        this.sysUserMapper.update(sysUserPo);
        return this.queryById(sysUserPo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysUserMapper.deleteById(id) > 0;
    }
}

