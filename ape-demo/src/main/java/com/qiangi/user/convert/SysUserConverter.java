package com.qiangi.user.convert;

import com.qiangi.user.entity.po.SysUser;
import com.qiangi.user.entity.req.SysUserReq;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SysUserConverter {

    SysUserConverter INSTANCE = Mappers.getMapper(SysUserConverter.class);

    SysUser convertReqToSysUser(SysUserReq sysUserReq);

}
