package com.mirror.finance.biz.mapper;

import com.mirror.finance.biz.domain.MqMsg;
import com.mirror.mybatis.help.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MqMsgMapper extends CommonMapper<MqMsg> {
}