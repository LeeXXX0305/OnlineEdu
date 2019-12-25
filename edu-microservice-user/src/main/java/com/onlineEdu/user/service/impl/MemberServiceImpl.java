package com.onlineEdu.user.service.impl;

import com.onlineEdu.user.entity.Member;
import com.onlineEdu.user.mapper.MemberMapper;
import com.onlineEdu.user.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author Elaine
 * @since 2019-12-24
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {
    @Override
    public Integer countRegisterByDay(String day){
        return baseMapper.selectRegisterCount(day);
    }

}
