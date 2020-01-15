package com.onlineEdu.common.handler;

import com.onlineEdu.common.constants.ResultCodeEnum;
import com.onlineEdu.common.exception.LoginException;
import com.onlineEdu.common.vo.ResultVo;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//统一异常处理器
@ControllerAdvice
@CrossOrigin
public class GlobalExceptionHandler {

    //通用异常处理方法
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResultVo error(Exception e){
        if (e instanceof LoginException) {
            LoginException loginException = (LoginException) e;
            e.printStackTrace();
            return ResultVo.error().code(loginException.getCode()).message(loginException.getMessage());
        }else{
            e.printStackTrace();
            return ResultVo.error();
        }
    }

    @ResponseBody
    @ExceptionHandler(BadSqlGrammarException.class)
    public ResultVo error(BadSqlGrammarException e){
        e.printStackTrace();
        return ResultVo.setResult(ResultCodeEnum.BAD_SQL_GRAMMAR);
    }

}
