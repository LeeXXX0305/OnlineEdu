package com.onlineEdu.sysuser.controller.admin;

import com.onlineEdu.common.vo.ResultVo;
import com.onlineEdu.sysuser.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(description = "阿里云视频管理")
@CrossOrigin
@RestController
@RequestMapping("/admin/vod/video")
public class VideoAdminController {
    @Autowired
    private VideoService videoService;

    @PostMapping("upload")
    public ResultVo uploadVideo(
            @ApiParam(name = "file", value = "文件", required = true)
            @RequestParam("file") MultipartFile file){

        String videoId = videoService.uploadVideo(file);
        return ResultVo.ok().message("视频文件上传成功").data("videoId", videoId);
    }
}
