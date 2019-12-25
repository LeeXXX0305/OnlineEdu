package com.onlineEdu.vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.onlineEdu.vod.dto.ChapterDto;
import com.onlineEdu.vod.dto.VideoDto;
import com.onlineEdu.vod.entity.Chapter;
import com.onlineEdu.vod.entity.Video;
import com.onlineEdu.vod.mapper.ChapterMapper;
import com.onlineEdu.vod.mapper.VideoMapper;
import com.onlineEdu.vod.service.ChapterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author Elaine
 * @since 2019-11-29
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public void removeChapterById(String id) {

        //删除云视频：向mq发请求

        //根据章节id删除所有视频
        QueryWrapper<Video> queryWrapperVideo = new QueryWrapper<>();
        queryWrapperVideo.eq("chapter_id", id);
        videoMapper.delete(queryWrapperVideo);

        //根据章节id删除章节
        baseMapper.deleteById(id);
    }

    @Override
    public List<ChapterDto> nestedList(String courseId) {

        //最终要的到的数据列表
        ArrayList<ChapterDto> chapterDtoArrayList = new ArrayList<>();

        //获取章节信息
        QueryWrapper<Chapter> queryWrapperChapter = new QueryWrapper<>();
        queryWrapperChapter.eq("course_id", courseId);
        queryWrapperChapter.orderByAsc("sort", "id");
        List<Chapter> chapters = baseMapper.selectList(queryWrapperChapter);

        //获取课时信息
        QueryWrapper<Video> queryWrapperVideo = new QueryWrapper<>();
        queryWrapperVideo.eq("course_id", courseId);
        queryWrapperVideo.orderByAsc("sort", "id");
        List<Video> videos = videoMapper.selectList(queryWrapperVideo);

        //填充章节vo数据
        for (int i = 0; i < chapters.size(); i++) {
            Chapter chapter = chapters.get(i);

            //创建章节vo对象
            ChapterDto chapterDto= new ChapterDto();
            BeanUtils.copyProperties(chapter, chapterDto);
            chapterDtoArrayList.add(chapterDto);

            //填充视频vo数据
            ArrayList<VideoDto> videoDtoArrayList = new ArrayList<>();
            for (int j = 0; j < videos.size(); j++) {

                Video video = videos.get(j);
                if(chapter.getId().equals(video.getChapterId())){

                    //创建视频vo对象
                    VideoDto videoDto = new VideoDto();
                    BeanUtils.copyProperties(video, videoDto);
                    videoDtoArrayList.add(videoDto);
                }
            }
            chapterDto.setChildren(videoDtoArrayList);
        }
        return chapterDtoArrayList;
    }

    @Override
    public Chapter getChapterById(String id){
        return baseMapper.selectById(id);
    }

}
