package com.qiangi.user.convert;

import com.qiangi.user.entity.po.SysUser;
import com.qiangi.user.entity.req.SysUserReq;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-18T15:18:48+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_422 (Amazon.com Inc.)"
)
public class SysUserConverterImpl implements SysUserConverter {

    @Override
    public SysUser convertReqToSysUser(SysUserReq sysUserReq) {
        if ( sysUserReq == null ) {
            return null;
        }

        SysUser sysUser = new SysUser();

        return sysUser;
    }
}
