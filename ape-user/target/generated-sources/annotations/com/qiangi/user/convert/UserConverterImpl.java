package com.qiangi.user.convert;

import com.qiangi.user.entity.po.UserPo;
import com.qiangi.user.entity.req.UserReq;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-11T19:42:36+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_422 (Amazon.com Inc.)"
)
public class UserConverterImpl implements UserConverter {

    @Override
    public UserPo convertUserReqToPo(UserReq userReq) {
        if ( userReq == null ) {
            return null;
        }

        UserPo userPo = new UserPo();

        userPo.setName( userReq.getName() );
        userPo.setAge( userReq.getAge() );

        return userPo;
    }
}
