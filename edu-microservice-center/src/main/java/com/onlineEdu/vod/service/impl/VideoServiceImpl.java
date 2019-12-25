package com.onlineEdu.vod.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.onlineEdu.vod.dto.VideoInfoDto;
import com.onlineEdu.vod.entity.Video;
import com.onlineEdu.vod.mapper.VideoMapper;
import com.onlineEdu.vod.service.VideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author Elaine
 * @since 2019-11-29
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {
    @Override
    public void saveVideoInfo(VideoInfoDto videoInfoDto) {

        Video video = new Video();
        BeanUtils.copyProperties(videoInfoDto, video);
        this.save(video);
    }

    @Override
    public VideoInfoDto getVideoInfoById(String id) {
        //从video表中取数据
        Video video = this.getById(id);
        //创建videoInfoDto对象
        VideoInfoDto videoInfoDto = new VideoInfoDto();
        BeanUtils.copyProperties(video, videoInfoDto);

        return videoInfoDto;
    }

    @Override
    public void updateVideoInfoById(VideoInfoDto videoInfoDto) {
        //保存课时基本信息
        Video video = new Video();
        BeanUtils.copyProperties(videoInfoDto, video);
        this.updateById(video);
    }

    @Override
    public void removeVideoById(String id) {

        //删除视频资源 TODO

        baseMapper.deleteById(id);
    }
}
