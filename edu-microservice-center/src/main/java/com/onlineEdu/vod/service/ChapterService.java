package com.onlineEdu.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.onlineEdu.vod.dto.ChapterDto;
import com.onlineEdu.vod.entity.Chapter;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author Elaine
 * @since 2019-11-29
 */
public interface ChapterService extends IService<Chapter> {
    Chapter getChapterById(String id);
    void removeChapterById(String id);
    List<ChapterDto> nestedList(String courseId);

}
