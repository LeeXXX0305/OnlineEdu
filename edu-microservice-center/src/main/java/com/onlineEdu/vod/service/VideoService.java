package com.onlineEdu.vod.service;

import com.onlineEdu.vod.dto.VideoInfoDto;
import com.onlineEdu.vod.entity.Video;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author Elaine
 * @since 2019-11-29
 */
public interface VideoService extends IService<Video> {
    void saveVideoInfo(VideoInfoDto videoInfoDto);

    VideoInfoDto getVideoInfoById(String id);
    void updateVideoInfoById(VideoInfoDto videoInfoDto);
    void removeVideoById(String id);
}
