package com.onlineEdu.edu.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel(value = "Teacher查询对象", description = "讲师查询对象封装")
@Data
public class TeacherDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Integer level;

    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

}
