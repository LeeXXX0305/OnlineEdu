package com.onlineEdu.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.onlineEdu.edu.dto.TeacherDto;
import com.onlineEdu.edu.entity.Teacher;
import com.onlineEdu.edu.mapper.TeacherMapper;
import com.onlineEdu.edu.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author Elaine
 * @since 2019-11-29
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Override
    public void pageQuery(Page<Teacher> pageParam, TeacherDto teacherDto) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");

        if(teacherDto == null){
            baseMapper.selectPage(pageParam,queryWrapper);
            return;
        }

        String name = teacherDto.getName();
        Integer level = teacherDto.getLevel();
        String begin = teacherDto.getBegin();

        if(!StringUtils.isEmpty(name)){
            queryWrapper.like("name", name);
        }
        if(!StringUtils.isEmpty(level)){
            queryWrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(begin)){
            queryWrapper.ge("gmt_create", begin);
        }
        baseMapper.selectPage(pageParam, queryWrapper);
    }
}
