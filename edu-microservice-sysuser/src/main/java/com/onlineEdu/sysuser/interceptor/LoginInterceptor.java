package com.onlineEdu.sysuser.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.onlineEdu.common.constants.UserStatusEnum;
import com.onlineEdu.common.exception.LoginException;
import com.onlineEdu.common.utils.JwtTokenUtil;
import com.onlineEdu.common.vo.ResultVo;
import com.onlineEdu.sysuser.entity.Token;
import com.onlineEdu.sysuser.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenService tokenService;
    //提供查询
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {}
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {}

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if(request.getMethod().equals("OPTIONS")){
//            response.setStatus(HttpServletResponse.SC_OK);
//            return true;
//        }
        //此处为不需要登录的接口放行
        if (request.getRequestURI().contains("/login") || request.getRequestURI().contains("/register") || request.getRequestURI().contains("/error")) {
            return true;
        }
        //权限路径拦截
        //PrintWriter resultWriter = arg1.getOutputStream();
        // TODO: 有时候用PrintWriter 会报 getWriter() has already been called for this response
        //换成ServletOutputStream就OK了
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        final String headerToken=request.getHeader(JwtTokenUtil.TOKEN_HEADER);
        //判断请求信息
        if(null==headerToken||headerToken.trim().equals("")||!headerToken.startsWith(JwtTokenUtil.TOKEN_PREFIX)){
//            throw new LoginException(50001,"token无效");
//            throw new RuntimeException("用户未登陆");
//            returnError(response,UserStatusEnum.INVALID_REQUEST);
            throw new LoginException(UserStatusEnum.INVALID_REQUEST);
        }
        //解析token信息
        try{
            String token = headerToken.replace(JwtTokenUtil.TOKEN_PREFIX, "");
            String tokenUserId= JwtTokenUtil.getId(token);
            //根据客户Token查找数据库Token
            Token myToken= tokenService.getTokenByUserId(tokenUserId);

            //数据库没有Token记录
            if(null==myToken) {
                throw new LoginException(UserStatusEnum.INVALID_REQUEST);
            }
            //数据库Token与客户Token比较
            if( !token.equals(myToken.getToken()) ){
                throw new LoginException(UserStatusEnum.INVALID_REQUEST);
            }
            //判断Token过期
            if(JwtTokenUtil.isExpiration(token)){
                throw new LoginException(UserStatusEnum.TOKEN_EXPIRED);
            }
        } catch (Exception e) {
            throw new LoginException(UserStatusEnum.INVALID_REQUEST);
        }
        //最后才放行
        return true;
    }

    private void returnError(HttpServletResponse response, UserStatusEnum userStatusEnum){
        ResultVo resultVo = ResultVo.error()
                .code(userStatusEnum.getCode())
                .message(userStatusEnum.getMessage());
        String jsonStr = JSONObject.toJSONString(resultVo);

        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(jsonStr);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}

