package com.onlineEdu.vod.mapper;

import com.onlineEdu.vod.dto.CourseInfoDto;
import com.onlineEdu.vod.dto.CoursePublishDto;
import com.onlineEdu.vod.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author Elaine
 * @since 2019-11-29
 */
public interface CourseMapper extends BaseMapper<Course> {
    CoursePublishDto selectCoursePublishInfoById(String id);
    CourseInfoDto selectCourseInfoById(String id);
}
