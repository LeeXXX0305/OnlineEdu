package com.onlineEdu.user.mapper;

import com.onlineEdu.user.entity.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author Elaine
 * @since 2019-12-24
 */
public interface MemberMapper extends BaseMapper<Member> {
    Integer selectRegisterCount(String day);

}
