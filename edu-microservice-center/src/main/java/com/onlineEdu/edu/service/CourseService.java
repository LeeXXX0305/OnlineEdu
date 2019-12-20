package com.onlineEdu.edu.service;

import com.onlineEdu.edu.dto.CourseInfoDto;
import com.onlineEdu.edu.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author Elaine
 * @since 2019-11-29
 */
public interface CourseService extends IService<Course> {

    /**
     * 保存课程信息
     * @param courseInfoDto
     * @return 新生成课程的id
     */
    String saveCourse(CourseInfoDto courseInfoDto);

    CourseInfoDto getCourseInfoById(String id);
}
