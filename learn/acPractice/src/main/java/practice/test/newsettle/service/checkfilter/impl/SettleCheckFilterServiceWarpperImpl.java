package practice.test.newsettle.service.checkfilter.impl;

import com.xQuant.base.exception.IRBaseException;
import com.xQuant.platform.app.newsettle.entity.settledefine.FlowType;
import com.xQuant.platform.app.newsettle.service.checkfilter.SettleCheckFilterService;
import com.xQuant.platform.app.newsettle.service.checkfilter.SettleCheckFilterServiceWarpper;
import com.xQuant.platform.app.newsettle.service.task.TaskFlowService;
import com.xQuant.platform.common.tp.entity.CashInstruction;
import com.xQuant.platform.common.tp.entity.Instruction;
import com.xQuant.platform.common.tp.entity.SecuInstruction;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author yu.zhang
 * @Description: 结算校验以及结算流程过滤等策略服务实现
 * @date 2019/8/30 16:09
 */
//@Component
public class SettleCheckFilterServiceWarpperImpl implements InitializingBean, SettleCheckFilterServiceWarpper {

    @Autowired
    private List<SettleCheckFilterService> SettleCheckFilterServices;

    private Map<String, SettleCheckFilterService> map;

    @Override
    public void afterPropertiesSet() throws Exception {

        map = new HashMap<String, SettleCheckFilterService>();

        if (SettleCheckFilterServices != null) {
            for (SettleCheckFilterService service : SettleCheckFilterServices) {
                for (String trdType : service.getSupportedTrdTypes()) {
                    map.put(trdType, service);
                }
            }
        }
    }

    private SettleCheckFilterService getDelegate(String trdType) {
        SettleCheckFilterService service = map.get(trdType);
        if (service != null) {
            return service;
        } else {
            return map.get("default");
        }
    }

    @Override
    public void operCheckVaild(Instruction mainInst, List<CashInstruction> cashInstList, List<SecuInstruction> secuInstList) {
        if (StringUtils.isNotBlank(mainInst.getTrdType())) {
            getDelegate(mainInst.getTrdType()).operCheckVaild(mainInst, cashInstList, secuInstList);
        } else {
            throw new IRBaseException("没有业务类型，错？");
        }
    }

    @Override
    public void operFlowCheckVaild(Instruction mainInst, boolean direction) {
        if (StringUtils.isNotBlank(mainInst.getTrdType())) {
            getDelegate(mainInst.getTrdType()).operFlowCheckVaild(mainInst, direction);
        } else {
            throw new IRBaseException("没有业务类型，错？");
        }
    }

    @Override
    public void operFlowCheckVaildFx(Instruction mainInst, boolean direction) {
        if (StringUtils.isNotBlank(mainInst.getTrdType())) {
            getDelegate(mainInst.getTrdType()).operFlowCheckVaildFx(mainInst, direction);
        } else {
            throw new IRBaseException("没有业务类型，错？");
        }
    }

    @Override
    public void settleFlowCheckVaild(Instruction mainInst, boolean direction) {
        if (StringUtils.isNotBlank(mainInst.getTrdType())) {
            getDelegate(mainInst.getTrdType()).settleFlowCheckVaild(mainInst, direction);
        } else {
            throw new IRBaseException("没有业务类型，错？");
        }
    }

    @Override
    public void settleFlowCheckVaildFx(Instruction mainInst, boolean direction) {
        if (StringUtils.isNotBlank(mainInst.getTrdType())) {
            getDelegate(mainInst.getTrdType()).settleFlowCheckVaildFx(mainInst, direction);
        } else {
            throw new IRBaseException("没有业务类型，错？");
        }
    }

    @Override
    public void settleFlowTypeFilter(LinkedList<TaskFlowService> linked, FlowType flowType, String direction, String trdType) {
        getDelegate(trdType).settleFlowTypeFilter(linked, flowType, direction, trdType);
    }
}
