package com.onlineEdu.sysuser.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.onlineEdu.sysuser.dto.TeacherDto;
import com.onlineEdu.sysuser.entity.Teacher;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author Elaine
 * @since 2019-11-29
 */
public interface TeacherService extends IService<Teacher> {

    void pageQuery(Page<Teacher> pageParam, TeacherDto teacherDto);
}
