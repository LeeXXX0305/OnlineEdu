package com.onlineEdu.sysuser.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.onlineEdu.common.vo.ResultVo;
import com.onlineEdu.sysuser.dto.ChapterDto;
import com.onlineEdu.sysuser.dto.CourseInfoDto;
import com.onlineEdu.sysuser.dto.CourseSearchDto;
import com.onlineEdu.sysuser.entity.Course;
import com.onlineEdu.sysuser.service.ChapterService;
import com.onlineEdu.sysuser.service.CourseService;
import com.onlineEdu.sysuser.service.SubjectService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author Elaine
 * @since 2019-11-29
 */
@CrossOrigin
@RestController
@RequestMapping("/edu/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private ChapterService chapterService;

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

    @ApiOperation(value = "根据ID查询课程")
    @GetMapping("{id}")
    public ResultVo getCourseInfo(@PathVariable String id){
        CourseInfoDto courseInfoDto = courseService.getCourseInfoById(id);

        List<ChapterDto> chapterDtoList = chapterService.nestedList(id);

        return ResultVo.ok().data("course", courseInfoDto).data("chapterList", chapterDtoList);
    }
}

