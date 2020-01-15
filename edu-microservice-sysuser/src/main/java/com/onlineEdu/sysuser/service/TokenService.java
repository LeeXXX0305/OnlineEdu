package com.onlineEdu.sysuser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.onlineEdu.sysuser.dto.LoginDto;
import com.onlineEdu.sysuser.dto.TokenDto;
import com.onlineEdu.sysuser.entity.Token;

public interface TokenService  extends IService<Token> {
    Token getTokenByUserId(String userId);

    TokenDto login(LoginDto loginDto);
}
