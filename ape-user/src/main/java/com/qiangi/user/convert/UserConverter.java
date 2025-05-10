package com.qiangi.user.convert;

import com.qiangi.user.entity.po.UserPo;
import com.qiangi.user.entity.req.UserReq;
import com.qiangi.user.mapper.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConverter {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    UserPo convertUserReqToPo(UserReq userReq);
}
