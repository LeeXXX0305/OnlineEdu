package com.onlineEdu.sysuser.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.onlineEdu.sysuser.entity.Subject;
import com.onlineEdu.sysuser.mapper.SubjectMapper;
import com.onlineEdu.sysuser.service.SubjectService;
import com.onlineEdu.sysuser.vo.SubjectNestedVo;
import com.onlineEdu.sysuser.vo.SubjectVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author Elaine
 * @since 2019-11-29
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {
    @Override
    public List<SubjectNestedVo> nestedList(){
        //最终要得到的数据列表
        ArrayList<SubjectNestedVo> subjectNestedVoArrayList = new ArrayList<>();

        //一级分类数据
        QueryWrapper<Subject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", 0);
        queryWrapper.orderByAsc("sort", "id");
        List<Subject> subjects = baseMapper.selectList(queryWrapper);

        //获取二级分类数据
        QueryWrapper<Subject> nestedSubjectQuery = new QueryWrapper<>();
        nestedSubjectQuery.ne("parent_id", 0);
        nestedSubjectQuery.orderByAsc("sort", "id");
        List<Subject> subSubjects = baseMapper.selectList(nestedSubjectQuery);

        //填充一级分类vo
        int count = subjects.size();
        for(int i = 0; i < count; i++){
            Subject subject = subjects.get(i);

            //创建一级分类vo对象
            SubjectNestedVo subjectNestedVo = new SubjectNestedVo();
            BeanUtils.copyProperties(subject, subjectNestedVo);

            //填充二级分类vo数据
            ArrayList<SubjectVo> subjectVoArrayList = new ArrayList<>();
            int subCount = subSubjects.size();
            for(int j = 0; j < subCount; j++){
                Subject subSubject = subSubjects.get(j);
                if(subject.getId().equals(subSubject.getParentId())){
                    SubjectVo subjectVo = new SubjectVo();
                    BeanUtils.copyProperties(subSubject, subjectVo);
                    subjectVoArrayList.add(subjectVo);
                }
            }
            subjectNestedVo.setChildren(subjectVoArrayList);
            subjectNestedVoArrayList.add(subjectNestedVo);
        }
        return subjectNestedVoArrayList;
    }

    @Override
    public Subject getSubjectById(String id){
        return baseMapper.selectById(id);
    }
}
