package com.onlineEdu.sysuser.controller;

import com.onlineEdu.common.utils.JwtTokenUtil;
import com.onlineEdu.common.vo.ResultVo;
import com.onlineEdu.sysuser.dto.LoginDto;
import com.onlineEdu.sysuser.dto.TokenDto;
import com.onlineEdu.sysuser.service.TokenService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("admin/sysuser")
public class SysuserController {
    @Autowired
    private TokenService tokenService;

    @ApiOperation(value="登录")
    @PostMapping("login")
    public ResultVo login(@RequestBody LoginDto loginDto){
        TokenDto tokenDto = tokenService.login(loginDto);
        if(tokenDto.getCode() == 200){
            return ResultVo.ok().data("token",tokenDto.getToken());
        }else{
            return ResultVo.error().code(tokenDto.getCode()).message(tokenDto.getMessage());
        }
    }

    @ApiOperation(value="获取用户信息")
    @GetMapping("info")
    //TODO:从数据库获取用户信息
    public ResultVo getInfo(@RequestParam String token){
        String userId = JwtTokenUtil.getId(token);
        if(userId.equals("1")) {
            String roles[] = new String[2];
            roles[0] = "admin";
            roles[1] = "teacher";
            return ResultVo.ok()
                    .data("roles", roles)
                    .data("name", "admin")
                    .data("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        }else{
            String roles[] = new String[1];
            roles[0] = "teacher";
            return ResultVo.ok()
                    .data("roles", roles)
                    .data("name", "admin")
                    .data("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        }
    }

    @ApiOperation(value="登出")
    @PostMapping("logout")
    public ResultVo logout(){
        return ResultVo.ok();
    }
}
