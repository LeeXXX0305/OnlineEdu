package com.onlineEdu.sysuser.mapper;

import com.onlineEdu.sysuser.dto.CourseInfoDto;
import com.onlineEdu.sysuser.dto.CoursePublishDto;
import com.onlineEdu.sysuser.entity.Course;
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
