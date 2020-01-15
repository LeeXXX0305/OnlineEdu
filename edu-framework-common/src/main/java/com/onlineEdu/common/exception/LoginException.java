package com.onlineEdu.common.exception;

import com.onlineEdu.common.constants.UserStatusEnum;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "自定义登录异常类")
public class LoginException extends RuntimeException {
    private int code;
    private String message;

    public LoginException(Integer code, String message){
        this.message = message;
        this.code = code;
    }

    public LoginException(UserStatusEnum userStatusEnum){
        this.message = userStatusEnum.getMessage();
        this.code = userStatusEnum.getCode();
    }

    @Override
    public String toString() {
        return "LoginException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
