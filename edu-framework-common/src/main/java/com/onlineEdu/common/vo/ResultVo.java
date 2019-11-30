package com.onlineEdu.common.vo;

import com.baomidou.mybatisplus.extension.api.R;
import com.onlineEdu.common.constants.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@ApiModel(value = "全局统一返回结果")
public class ResultVo {
    @ApiModelProperty(value = "是否成功")
    private boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    private ResultVo(){}

    public static ResultVo ok(){
        ResultVo r = new ResultVo();
        r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return r;
    }

    public static ResultVo error(){
        ResultVo r = new ResultVo();
        r.setSuccess(ResultCodeEnum.UNKNOWN_REASON.getSuccess());
        r.setCode(ResultCodeEnum.UNKNOWN_REASON.getCode());
        r.setMessage(ResultCodeEnum.UNKNOWN_REASON.getMessage());
        return r;
    }
    public ResultVo data(Map<String, Object> map){
        this.setData(map);
        return this;
    }

    public ResultVo data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public ResultVo message(String message){
        this.setMessage(message);
        return this;
    }

    public ResultVo code(Integer code){
        this.setCode(code);
        return this;
    }

    public ResultVo success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public static ResultVo setResult(ResultCodeEnum resultCodeEnum){
        ResultVo r = new ResultVo();
        r.setSuccess(resultCodeEnum.getSuccess());
        r.setCode(resultCodeEnum.getCode());
        r.setMessage(resultCodeEnum.getMessage());
        return r;
    }
}
