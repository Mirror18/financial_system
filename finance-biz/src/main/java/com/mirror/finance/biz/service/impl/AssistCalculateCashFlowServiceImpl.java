package com.mirror.finance.biz.service.impl;

import cn.hutool.extra.pinyin.PinyinUtil;
import com.mirror.common.exception.BizException;
import com.mirror.common.service.TokenService;
import com.mirror.finance.biz.config.ObjectConvertor;
import com.mirror.finance.biz.domain.AssistCalculateCashFlow;
import com.mirror.finance.biz.dto.AdminDTO;
import com.mirror.finance.biz.dto.form.CreateAssistCalculateCashFlowForm;
import com.mirror.finance.biz.dto.form.GetAssistCalculateCashFlowVo;
import com.mirror.finance.biz.dto.form.UpdateAssistCalculateCashFlowForm;
import com.mirror.finance.biz.dto.vo.ListAssistCalculateCashFlowVo;
import com.mirror.finance.biz.enums.AssistCalculateCateCodeEnum;
import com.mirror.finance.biz.mapper.AssistCalculateCashFlowMapper;
import com.mirror.finance.biz.service.AssistCalculateHandleService;
import com.mirror.mybatis.help.MyBatisWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.mirror.finance.biz.domain.AssistCalculateCashFlowField.*;

/**
 * @author mirror
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AssistCalculateCashFlowServiceImpl implements AssistCalculateHandleService {
    final AssistCalculateCashFlowMapper mapper;
    final ObjectConvertor objectConvertor;
    final TokenService<AdminDTO> tokenService;

    @Override
    public AssistCalculateCateCodeEnum getAssistCalculateCateCodeEnum() {
        return AssistCalculateCateCodeEnum.CASH_FLOW;
    }

    /**
     * 添加现金流辅助核算
     *
     * @param obj
     * @return
     */
    @Override
    public boolean create(Object obj) {
        CreateAssistCalculateCashFlowForm form = (CreateAssistCalculateCashFlowForm) obj;
        AssistCalculateCashFlow assistCalculateCashFlow = objectConvertor.toAssistCalculateCashFlow(form);
        assistCalculateCashFlow.initDefault();
        assistCalculateCashFlow.setMemberId(tokenService.getThreadLocalUserId());
        assistCalculateCashFlow.setUpdateMemberId(tokenService.getThreadLocalUserId());
        assistCalculateCashFlow.setTenantId(tokenService.getThreadLocalTenantId());
        return mapper.insert(assistCalculateCashFlow) > 0;
    }

    /**
     * 查询客户辅助核算客户列表
     *
     * @return
     */
    @Override
    public List<ListAssistCalculateCashFlowVo> listByAssistCalculateSummaryIds(List<Long> assistCalculateSummaryIds) {
        MyBatisWrapper<AssistCalculateCashFlow> wrapper = new MyBatisWrapper<>();
        wrapper.select(Id, CashFlowCate, Disable, AssistCalculateSummaryId)
                .whereBuilder()
                .andEq(TenantId, tokenService.getThreadLocalTenantId())
                .andEq(DelFlag, false)
                .andIn(AssistCalculateSummaryId, assistCalculateSummaryIds);
        List<AssistCalculateCashFlow> assistCalculates = mapper.list(wrapper);
        return objectConvertor.toListAssistCalculateCashFlowVo(assistCalculates);
    }

    /**
     * 修改现金流辅助核算
     *
     * @param obj
     * @return
     */
    @Override
    public boolean update(Object obj) {
        UpdateAssistCalculateCashFlowForm form = (UpdateAssistCalculateCashFlowForm) obj;
        MyBatisWrapper<AssistCalculateCashFlow> wrapper = new MyBatisWrapper<>();
        wrapper
                .update(UpdateTime, new Date())
                .update(UpdateMemberId, tokenService.getThreadLocalUserId())
                .update(CashFlowCate, form.getCashFlowCate())
                .whereBuilder()
                .andEq(Id, form.getId())
                .andEq(TenantId, tokenService.getThreadLocalTenantId())
                .andEq(DelFlag, false);
        if (mapper.updateField(wrapper) == 0) {
            throw new BizException("修改失败");
        }
        return true;
    }

    /**
     * 获取现金流辅助核算详情
     *
     * @param id
     * @return
     */
    @Override
    public GetAssistCalculateCashFlowVo get(long id) {
        AssistCalculateCashFlow assistCalculateCashFlow = getById(id);
        return objectConvertor.toGetAssistCalculateCashFlowVo(assistCalculateCashFlow);
    }

    /**
     * 查询现金流辅助核算明细
     *
     * @param id
     * @return
     */
    private AssistCalculateCashFlow getById(long id) {
        MyBatisWrapper<AssistCalculateCashFlow> wrapper = new MyBatisWrapper<>();
        wrapper.select(Id, CashFlowCate)
                .whereBuilder()
                .andEq(Id, id)
                .andEq(DelFlag, false)
                .andEq(TenantId, tokenService.getThreadLocalTenantId());
        return mapper.get(wrapper);
    }
}
