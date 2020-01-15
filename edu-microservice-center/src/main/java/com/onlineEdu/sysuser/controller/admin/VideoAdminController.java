package com.onlineEdu.sysuser.controller.admin;

import com.onlineEdu.common.vo.ResultVo;
import com.onlineEdu.sysuser.dto.VideoInfoDto;
import com.onlineEdu.sysuser.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description="课时管理")
@CrossOrigin //跨域
@RestController
@RequestMapping("/admin/edu/video")
public class VideoAdminController {
    @Autowired
    private VideoService videoService;

    @ApiOperation(value = "新增课时")
    @PostMapping("save-video-info")
    public ResultVo save(
            @ApiParam(name = "videoForm", value = "课时对象", required = true)
            @RequestBody VideoInfoDto videoInfoDto){

        videoService.saveVideoInfo(videoInfoDto);
        return ResultVo.ok();
    }

    @ApiOperation(value = "根据ID查询课时")
    @GetMapping("video-info/{id}")
    public ResultVo getVideInfoById(
            @ApiParam(name = "id", value = "课时ID", required = true)
            @PathVariable String id){

        VideoInfoDto videoInfoDto = videoService.getVideoInfoById(id);
        return ResultVo.ok().data("item", videoInfoDto);
    }

    @ApiOperation(value = "更新课时")
    @PutMapping("update-video-info/{id}")
    public ResultVo updateCourseInfoById(
            @ApiParam(name = "VideoInfoForm", value = "课时基本信息", required = true)
            @RequestBody VideoInfoDto videoInfoDto,

            @ApiParam(name = "id", value = "课时ID", required = true)
            @PathVariable String id){

        videoService.updateVideoInfoById(videoInfoDto);
        return ResultVo.ok();
    }

    @ApiOperation(value = "根据ID删除课时")
    @DeleteMapping("{id}")
    public ResultVo removeById(
            @ApiParam(name = "id", value = "课时ID", required = true)
            @PathVariable String id){

        videoService.removeVideoById(id);
        return ResultVo.ok();
    }
}
