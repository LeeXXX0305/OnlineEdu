package com.onlineEdu.edu.controller;

import com.onlineEdu.common.vo.ResultVo;
import com.onlineEdu.edu.entity.Sysuser;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("admin/sysuser")
public class SysuserController {

    @PostMapping("login")
    public ResultVo login(@RequestBody Sysuser sysuser){
        return ResultVo.ok().data("token","admin");
    }

    @GetMapping("info")
    public ResultVo getInfo(@RequestParam String token){
        return ResultVo.ok()
                .data("roles","admin")
                .data("name","admin")
                .data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }

    @PostMapping("logout")
    public ResultVo logout(){
        return ResultVo.ok();
    }
}
