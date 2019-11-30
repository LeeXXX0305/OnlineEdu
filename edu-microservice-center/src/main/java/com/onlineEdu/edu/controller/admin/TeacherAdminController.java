package com.onlineEdu.edu.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.onlineEdu.common.vo.ResultVo;
import com.onlineEdu.edu.dto.TeacherDto;
import com.onlineEdu.edu.entity.Teacher;
import com.onlineEdu.edu.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "分页查询讲师列表")
    @GetMapping("getTeachersPage")
    public ResultVo getTeachersPage(@RequestParam(name="page") int page, @RequestParam(name = "limit") int limit){
        Page<Teacher> teacherPage = new Page<>(page, limit);
        teacherService.page(teacherPage, null);
        List<Teacher> records = teacherPage.getRecords();
        long total = teacherPage.getTotal();

        return ResultVo.ok().data("items", records).data("total", total);
    }

    @ApiOperation(value = "按条件查询讲师列表")
    @RequestMapping(value = "/getTeachers", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo getTeachers(@RequestParam(name="page") int page,
                                @RequestParam(name = "limit") int limit,
                                @RequestBody TeacherDto teacherDto){
        Page<Teacher> teacherPage = new Page<>(page, limit);

        teacherService.pageQuery(teacherPage, teacherDto);
        List<Teacher> records = teacherPage.getRecords();
        long total = teacherPage.getTotal();

        return ResultVo.ok().data("items", records).data("total", total);
    }
}
