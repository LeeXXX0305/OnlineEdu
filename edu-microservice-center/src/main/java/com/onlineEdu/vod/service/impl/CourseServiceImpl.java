package com.onlineEdu.vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.onlineEdu.vod.dto.CourseInfoDto;
import com.onlineEdu.vod.dto.CoursePublishDto;
import com.onlineEdu.vod.dto.CourseSearchDto;
import com.onlineEdu.vod.entity.Chapter;
import com.onlineEdu.vod.entity.Course;
import com.onlineEdu.vod.entity.CourseDescription;
import com.onlineEdu.vod.entity.Video;
import com.onlineEdu.vod.mapper.ChapterMapper;
import com.onlineEdu.vod.mapper.CourseDescriptionMapper;
import com.onlineEdu.vod.mapper.CourseMapper;
import com.onlineEdu.vod.mapper.VideoMapper;
import com.onlineEdu.vod.service.CourseService;
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

    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private ChapterMapper chapterMapper;
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
        CourseInfoDto courseInfoDto = baseMapper.selectCourseInfoById(id);
        CourseDescription courseDescription = courseDescriptionMapper.selectById(id);
        BeanUtils.copyProperties(courseDescription, courseInfoDto);

        return courseInfoDto;
    }

    @Override
    public CoursePublishDto getCoursePublishInfoById(String id) {
        return baseMapper.selectCoursePublishInfoById(id);
    }

    @Transactional
    @Override
    public void updateCourseInfoById(CourseInfoDto courseInfoDto) {
        //保存课程基本信息
        Course course = new Course();
        BeanUtils.copyProperties(courseInfoDto, course);
        baseMapper.updateById(course);

        //保存课程详情信息
        CourseDescription courseDescription = new CourseDescription();
        courseDescription.setDescription(courseInfoDto.getDescription());
        courseDescriptionMapper.updateById(courseDescription);
    }

    @Override
    public void pageQuery(Page<Course> pageParam, CourseSearchDto courseSearchDto) {

        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("gmt_create");

        if (courseSearchDto == null){
            baseMapper.selectPage(pageParam, queryWrapper);
            return;
        }

        String title = courseSearchDto.getTitle();
        String teacherId = courseSearchDto.getTeacherId();
        String subjectParentId = courseSearchDto.getSubjectParentId();
        String subjectId = courseSearchDto.getSubjectId();

        if (!StringUtils.isEmpty(title)) {
            queryWrapper.like("title", title);
        }

        if (!StringUtils.isEmpty(teacherId) ) {
            queryWrapper.eq("teacher_id", teacherId);
        }

        if (!StringUtils.isEmpty(subjectParentId)) {
            queryWrapper.ge("subject_parent_id", subjectParentId);
        }

        if (!StringUtils.isEmpty(subjectId)) {
            queryWrapper.ge("subject_id", subjectId);
        }

        baseMapper.selectPage(pageParam, queryWrapper);
    }

    @Transactional
    @Override
    public void removeCourseById(String id) {

        //根据id删除所有视频
        QueryWrapper<Video> queryWrapperVideo = new QueryWrapper<>();
        queryWrapperVideo.eq("course_id", id);
        videoMapper.delete(queryWrapperVideo);

        //根据id删除所有章节
        QueryWrapper<Chapter> queryWrapperChapter = new QueryWrapper<>();
        queryWrapperChapter.eq("course_id", id);
        chapterMapper.delete(queryWrapperChapter);

        //删除课程详情
        courseDescriptionMapper.deleteById(id);

        //根据id删除课程
        baseMapper.deleteById(id);
    }

    @Override
    public void publishCourseById(String id) {
        Course course = new Course();
        course.setId(id);
        course.setStatus(Course.COURSE_NORMAL);
        baseMapper.updateById(course);
    }
}
