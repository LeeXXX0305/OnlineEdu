package com.onlineEdu.vod.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.onlineEdu.common.constants.ResultCodeEnum;
import com.onlineEdu.common.exception.GuliException;
import com.onlineEdu.common.vo.ResultVo;
import com.onlineEdu.vod.dto.TeacherDto;
import com.onlineEdu.vod.entity.Teacher;
import com.onlineEdu.vod.service.TeacherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Elaine
 * @since 2019-11-29
 */
@CrossOrigin//跨域
@RestController
@RequestMapping("/edu/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public ResultVo list() {
        List<Teacher> list = teacherService.list(null);
        return ResultVo.ok().data("items", list);
    }

    @ApiOperation(value = "分页讲师列表")
    @GetMapping("{page}/{limit}")
    public ResultVo pageQuery(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "teacherQuery", value = "查询对象", required = false)
                    TeacherDto teacherDto){

        //业务逻辑错误，抛出自定义异常
        if(page <= 0 || limit <= 0){
            throw new GuliException(ResultCodeEnum.PARAM_ERROR);
        }

        Page<Teacher> pageParam = new Page<>(page, limit);

        teacherService.pageQuery(pageParam, teacherDto);
        List<Teacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return  ResultVo.ok().data("total", total).data("rows", records);
    }
}

