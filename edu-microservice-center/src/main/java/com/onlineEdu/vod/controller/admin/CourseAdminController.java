package com.onlineEdu.vod.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.onlineEdu.common.vo.ResultVo;
import com.onlineEdu.vod.dto.CourseInfoDto;
import com.onlineEdu.vod.dto.CoursePublishDto;
import com.onlineEdu.vod.dto.CourseSearchDto;
import com.onlineEdu.vod.entity.Course;
import com.onlineEdu.vod.service.CourseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("admin/edu/course")
public class CourseAdminController {

    @Autowired
    private CourseService courseService;

    @ApiOperation(value="新增课程")
    @PostMapping("save-course-info")
    public ResultVo saveCourse(@RequestBody CourseInfoDto courseInfoDto){
        String courseId = courseService.saveCourse(courseInfoDto);
        return ResultVo.ok().data("courseId", courseId);
    }

    @ApiOperation(value = "根据ID查询课程")
    @GetMapping("course-info/{id}")
    public ResultVo getCourseInfo(@PathVariable String id){
        CourseInfoDto courseInfoDto = courseService.getCourseInfoById(id);
        return ResultVo.ok().data("item", courseInfoDto);
    }

    @ApiOperation(value = "更新课程")
    @PutMapping("update-course-info/{id}")
    public ResultVo updateCourseInfoById(
            @ApiParam(name = "CourseInfoForm", value = "课程基本信息", required = true)
            @RequestBody CourseInfoDto courseInfoDto,

            @ApiParam(name = "id", value = "课程ID", required = true)
            @PathVariable String id){

        courseService.updateCourseInfoById(courseInfoDto);
        return ResultVo.ok();
    }

    @ApiOperation(value = "分页课程列表")
    @GetMapping("{page}/{limit}")
    public ResultVo pageQuery(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "courseQuery", value = "查询对象", required = false)
                    CourseSearchDto courseSearchDto){

        Page<Course> pageParam = new Page<>(page, limit);

        courseService.pageQuery(pageParam, courseSearchDto);
        List<Course> records = pageParam.getRecords();

        long total = pageParam.getTotal();

        return  ResultVo.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "根据ID获取课程发布信息")
    @GetMapping("course-publish-info/{id}")
    public ResultVo getCoursePublishVoById(
            @ApiParam(name = "id", value = "课程ID", required = true)
            @PathVariable String id){

        CoursePublishDto coursePublishDto = courseService.getCoursePublishInfoById(id);
        return ResultVo.ok().data("item", coursePublishDto);
    }

    @ApiOperation(value = "根据ID删除课程")
    @DeleteMapping("{id}")
    public ResultVo removeById(
            @ApiParam(name = "id", value = "课程ID", required = true)
            @PathVariable String id){
        courseService.removeCourseById(id);
        return ResultVo.ok();
    }

    @ApiOperation(value = "根据id发布课程")
    @PutMapping("publish-course/{id}")
    public ResultVo publishCourseById(
            @ApiParam(name = "id", value = "课程ID", required = true)
            @PathVariable String id){

        courseService.publishCourseById(id);
        return ResultVo.ok();
    }
}
