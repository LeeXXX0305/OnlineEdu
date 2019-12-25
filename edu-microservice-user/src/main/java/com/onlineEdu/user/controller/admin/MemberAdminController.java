package com.onlineEdu.user.controller.admin;

import com.onlineEdu.common.vo.ResultVo;
import com.onlineEdu.user.service.MemberService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("admin/ucenter/member")
public class MemberAdminController {
    @Autowired
    private MemberService memberService;

    @ApiOperation(value = "今日注册数")
    @GetMapping(value = "count-register/{day}")
    public ResultVo registerCount(
            @ApiParam(name = "day", value = "统计日期")
            @PathVariable String day){

        Integer count = memberService.countRegisterByDay(day);

        return ResultVo.ok().data("countRegister", count);
    }
}
