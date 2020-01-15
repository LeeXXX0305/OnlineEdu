package com.onlineEdu.sysuser.controller;

import com.onlineEdu.common.vo.ResultVo;
import com.onlineEdu.sysuser.service.VideoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description="阿里云视频点播微服务")
@CrossOrigin //跨域
@RestController
@RequestMapping("/vod/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping("get-play-auth/{videoId}")
    public ResultVo getVideoPlayAuth(@PathVariable String videoId){

        String playAuth = videoService.getVideoPlayAuth(videoId);
        return ResultVo.ok().message("获取播放凭证成功").data("playAuth", playAuth);
    }
}
