package com.onlineEdu.sysuser.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.onlineEdu.sysuser.dto.CourseInfoDto;
import com.onlineEdu.sysuser.dto.CoursePublishDto;
import com.onlineEdu.sysuser.dto.CourseSearchDto;
import com.onlineEdu.sysuser.entity.Course;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author Elaine
 * @since 2019-11-29
 */
public interface CourseService extends IService<Course> {

    String saveCourse(CourseInfoDto courseInfoDto);

    CourseInfoDto getCourseInfoById(String id);
    CoursePublishDto getCoursePublishInfoById(String id);
    void pageQuery(Page<Course> pageParam, CourseSearchDto courseSearchDto);
    void updateCourseInfoById(CourseInfoDto courseInfoDto);

    void removeCourseById(String id);

    void publishCourseById(String id);

}
