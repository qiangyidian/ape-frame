package com.qiangi.user.mapper;

import com.qiangi.user.entity.po.SysUserPo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 用户表(SysUserPo)表数据库访问层
 *
 * @author qiangi
 * @since 2025-05-11 19:31:17
 */
@Mapper
public interface SysUserMapper {

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
     * 统计总行数
     *
     * @param sysUserPo 查询条件
     * @return 总行数
     */
    long count(SysUserPo sysUserPo);

    /**
     * 新增数据
     *
     * @param sysUserPo 实例对象
     * @return 影响行数
     */
    int insert(SysUserPo sysUserPo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUserPo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysUserPo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUserPo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SysUserPo> entities);

    /**
     * 修改数据
     *
     * @param sysUserPo 实例对象
     * @return 影响行数
     */
    int update(SysUserPo sysUserPo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}


