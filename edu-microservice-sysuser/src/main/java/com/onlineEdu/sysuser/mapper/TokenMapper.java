package com.onlineEdu.sysuser.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.onlineEdu.sysuser.entity.Token;

public interface TokenMapper extends BaseMapper<Token> {

    Token findByUserId(String userId);
}
