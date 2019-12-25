package com.onlineEdu.vod.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.onlineEdu.common.constants.ResultCodeEnum;
import com.onlineEdu.common.exception.GuliException;
import com.onlineEdu.common.vo.ResultVo;
import com.onlineEdu.vod.dto.TeacherDto;
import com.onlineEdu.vod.entity.Teacher;
import com.onlineEdu.vod.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/edu/teacher")
@CrossOrigin//跨域
@Api(description = "讲师管理")
public class TeacherAdminController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public ResultVo list() {
        List<Teacher> list = teacherService.list(null);
        return ResultVo.ok().data("items", list);
    }

    @DeleteMapping("{id}")
    public ResultVo removeById(@PathVariable String id){
        teacherService.removeById(id);
        return ResultVo.ok();
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

//    @ApiOperation(value = "按条件查询讲师列表")
//    @RequestMapping(value = "/getTeachers", method = {RequestMethod.POST})
//    @ResponseBody
//    public ResultVo getTeachers(@RequestParam(name="page") int page,
//                                @RequestParam(name = "limit") int limit,
//                                @RequestBody TeacherDto teacherDto){
//        Page<Teacher> teacherPage = new Page<>(page, limit);
//
//        teacherService.pageQuery(teacherPage, teacherDto);
//        List<Teacher> records = teacherPage.getRecords();
//        long total = teacherPage.getTotal();
//
//        return ResultVo.ok().data("items", records).data("total", total);
//    }
}
