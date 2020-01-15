package com.onlineEdu.common.constants;

import lombok.Getter;

@Getter
public enum UserStatusEnum {
    VERIFY_SUCCESS(200,"匹配成功"),
    USER_NOT_EXISTS(10001,"用户不存在"),
    PWD_ERROR(10002, "密码错误"),

    TOKEN_EXPIRED(50001,"token已过期"),
    INVALID_REQUEST(50008,"无效token")
    ;

    private int code;
    private String message;

    UserStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
