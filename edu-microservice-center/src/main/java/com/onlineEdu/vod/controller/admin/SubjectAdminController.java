package com.onlineEdu.vod.controller.admin;

import com.onlineEdu.common.vo.ResultVo;
import com.onlineEdu.vod.service.SubjectService;
import com.onlineEdu.vod.vo.SubjectNestedVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:9528", maxAge = 3600)
@RestController
@RequestMapping("admin/edu/subject")
@Api(description = "课程分类列表")
public class SubjectAdminController {

    @Autowired
    SubjectService subjectService;

    @RequestMapping(value = "", method = {RequestMethod.GET})
    public ResultVo nestedList(){
        List<SubjectNestedVo> subjectNestedVoList = subjectService.nestedList();
        return ResultVo.ok().data("items", subjectNestedVoList);
    }
}
