package com.onlineEdu.sysuser.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.onlineEdu.common.constants.UserStatusEnum;
import com.onlineEdu.common.utils.JwtTokenUtil;
import com.onlineEdu.sysuser.dto.LoginDto;
import com.onlineEdu.sysuser.dto.TokenDto;
import com.onlineEdu.sysuser.entity.Sysuser;
import com.onlineEdu.sysuser.entity.Token;
import com.onlineEdu.sysuser.mapper.TokenMapper;
import com.onlineEdu.sysuser.service.TokenService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenServiceImpl extends ServiceImpl<TokenMapper, Token> implements TokenService {

    @Override
    public Token getTokenByUserId(String userId){
        return baseMapper.findByUserId(userId);
    }

    @Override
    public TokenDto login(LoginDto loginDto){

        //TODO:根据用户名查询数据库中的用户信息
        Sysuser user = new Sysuser();
        user.setId("1");
        user.setPassword("admin");
        user.setUsername("admin");

        //用户不存在
        if (user == null) {
            return new TokenDto(UserStatusEnum.USER_NOT_EXISTS.getCode(),UserStatusEnum.USER_NOT_EXISTS.getMessage(),null);
        }
        //密码错误
        //TODO:密码使用SHA256加密
        if(!loginDto.getPassword().equals(user.getPassword())){
            return new TokenDto(UserStatusEnum.PWD_ERROR.getCode(),UserStatusEnum.PWD_ERROR.getMessage(),null);
        }

        //查询用户的token
        String token = generateToken(user);
        return new TokenDto(UserStatusEnum.VERIFY_SUCCESS.getCode(),UserStatusEnum.VERIFY_SUCCESS.getMessage(),token);
    }


    private String generateToken(Sysuser user){
        Token token = baseMapper.findByUserId(user.getId());
        Date date = new Date();
        if(null == token){
            Token newToken = new Token();
            String tokenStr = JwtTokenUtil.createToken(user.getId(), user.getUsername());
            newToken.setUserId(user.getId());
            newToken.setToken(tokenStr);
            newToken.setCreateTime(date);
            baseMapper.insert(newToken);
            return tokenStr;
        }else{
            String tokenStr = JwtTokenUtil.createToken(user.getId(), user.getUsername());
            token.setToken(tokenStr);
            token.setCreateTime(date);
            baseMapper.updateById(token);
            return tokenStr;
        }
    }

//    private String setJWT(String userId, Date date){
//        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
//        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT") // 设置header
//                .setHeaderParam("alg", "HS256").setIssuedAt(date) // 设置签发时间
//                .setExpiration(new Date(date.getTime() + 1000 * 60 * 60))
//                .claim("userId",String.valueOf(userId) ) // 设置内容
//                .setIssuer("lws")// 设置签发人
//                .signWith(signatureAlgorithm, "aaaaaaaaaaaaaa"); // 签名，需要算法和key
//        return builder.compact();
//    }
}
