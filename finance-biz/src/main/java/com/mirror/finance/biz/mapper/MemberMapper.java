package com.mirror.finance.biz.mapper;

import com.mirror.finance.biz.domain.Member;
import com.mirror.mybatis.help.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper extends CommonMapper<Member> {
}