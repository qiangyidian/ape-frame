package com.qiangi.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qiangi.user.entity.po.UserPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
//注意必须是interface因为
public interface UserMapper extends BaseMapper<UserPo> {

    IPage<UserPo> getUserPage(IPage<UserPo> iPage);
}
