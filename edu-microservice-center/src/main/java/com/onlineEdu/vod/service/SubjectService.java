package com.onlineEdu.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.onlineEdu.vod.entity.Subject;
import com.onlineEdu.vod.vo.SubjectNestedVo;

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

    Subject getSubjectById(String id);

}
