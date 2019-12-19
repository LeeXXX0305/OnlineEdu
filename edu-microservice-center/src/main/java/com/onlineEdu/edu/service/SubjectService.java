package com.onlineEdu.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.onlineEdu.edu.entity.Subject;
import com.onlineEdu.edu.vo.SubjectNestedVo;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author Elaine
 * @since 2019-11-29
 */
public interface SubjectService extends IService<Subject> {

    List<SubjectNestedVo> nestedList();

}
