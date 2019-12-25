package com.onlineEdu.user.service;

import com.onlineEdu.user.entity.Member;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author Elaine
 * @since 2019-12-24
 */
public interface MemberService extends IService<Member> {
    Integer countRegisterByDay(String day);


}
