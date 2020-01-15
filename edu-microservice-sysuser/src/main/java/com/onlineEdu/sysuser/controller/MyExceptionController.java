package com.onlineEdu.sysuser.controller;

import com.onlineEdu.common.constants.UserStatusEnum;
import com.onlineEdu.common.exception.LoginException;
import com.onlineEdu.common.vo.ResultVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
@CrossOrigin
public class MyExceptionController {
    @ExceptionHandler(LoginException.class)
    public ResultVo errorTokenExceptionHandler() {
//        logger.info(ResponseEnum.ERROR_502.toString());
        return ResultVo.error().code(UserStatusEnum.INVALID_REQUEST.getCode()).message(UserStatusEnum.INVALID_REQUEST.getMessage());
    }
}
