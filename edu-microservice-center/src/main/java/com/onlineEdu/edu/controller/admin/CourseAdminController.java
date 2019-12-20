package com.onlineEdu.edu.controller.admin;

import com.onlineEdu.common.vo.ResultVo;
import com.onlineEdu.edu.dto.CourseInfoDto;
import com.onlineEdu.edu.service.CourseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("admin/edu/course")
public class CourseAdminController {

    @Autowired
    private CourseService courseService;

    @ApiOperation(value="新增课程")
    @PostMapping("saveCourse")
    public ResultVo saveCourse(@RequestBody CourseInfoDto courseInfoDto){
        String courseId = courseService.saveCourse(courseInfoDto);
        return ResultVo.ok().data("courseId", courseId);
    }

    @ApiOperation(value = "根据ID查询课程")
    @GetMapping("courseInfo")
    public ResultVo getCourseInfo(@RequestParam String id){
        CourseInfoDto courseInfoDto = courseService.getCourseInfoById(id);
        return ResultVo.ok().data("data", courseInfoDto);
    }

}
