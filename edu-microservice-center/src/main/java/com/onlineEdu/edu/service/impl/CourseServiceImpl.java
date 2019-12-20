package com.onlineEdu.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.onlineEdu.edu.dto.CourseInfoDto;
import com.onlineEdu.edu.entity.Course;
import com.onlineEdu.edu.entity.CourseDescription;
import com.onlineEdu.edu.mapper.CourseDescriptionMapper;
import com.onlineEdu.edu.mapper.CourseMapper;
import com.onlineEdu.edu.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author Elaine
 * @since 2019-11-29
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    private CourseDescriptionMapper courseDescriptionMapper;

    @Transactional
    @Override
    public String saveCourse(CourseInfoDto courseInfoDto){
        Course course = new Course();
        course.setStatus(Course.COURSE_DRAFT);
        BeanUtils.copyProperties(courseInfoDto, course);
        baseMapper.insert(course);

        CourseDescription courseDescription = new CourseDescription();
        courseDescription.setDescription(courseInfoDto.getDescription());
        courseDescription.setId(course.getId());
        courseDescriptionMapper.insert(courseDescription);

        return course.getId();
    }

    @Override
    public CourseInfoDto getCourseInfoById(String id){
        Course course = baseMapper.selectById(id);
        CourseDescription courseDescription = courseDescriptionMapper.selectById(id);
        CourseInfoDto courseInfoDto = new CourseInfoDto();
        BeanUtils.copyProperties(course, courseInfoDto);
        BeanUtils.copyProperties(courseDescription, courseInfoDto);

        return courseInfoDto;
    }

}
