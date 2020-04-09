package practice.test.newsettle.service.checkfilter.impl;

import com.xQuant.platform.app.newsettle.entity.settledefine.FlowType;
import com.xQuant.platform.app.newsettle.service.checkfilter.SettleCheckFilterService;
import com.xQuant.platform.app.newsettle.service.task.TaskFlowService;
import com.xQuant.platform.common.tp.entity.CashInstruction;
import com.xQuant.platform.common.tp.entity.Instruction;
import com.xQuant.platform.common.tp.entity.SecuInstruction;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yu.zhang
 * @Description: 默认实现策略类，其他业务继承这个默认实现
 * @date 2019/8/30 16:16
 */
//@Component
public class SettleCheckFilter4DefaultServiceImpl implements SettleCheckFilterService {

    @Override
    public String[] getSupportedTrdTypes() {
        return new String[]{"default"};
    }

    /**
     * 经办大校验策略实现部分
     */
    @Override
    public void operCheckVaild(Instruction mainInst, List<CashInstruction> cashInstList, List<SecuInstruction> secuInstList) {
        System.out.println("我是策略校验默认实现方法");
    }

    /**
     * 结算前代码校验
     */
    @Override
    public void operFlowCheckVaild(Instruction mainInst, boolean direction) {
        System.out.println("我是策略经办结算前校验默认实现方法");
    }

    /**
     * 结算前代码校验
     */
    @Override
    public void operFlowCheckVaildFx(Instruction mainInst, boolean direction) {
        flowCheckValidComon(mainInst, direction);
    }

    /**
     * 结算前代码校验
     */
    @Override
    public void settleFlowCheckVaild(Instruction mainInst, boolean direction) {
        flowCheckValidComon(mainInst, direction);
    }

    /**
     * 结算前代码校验
     */
    @Override
    public void settleFlowCheckVaildFx(Instruction mainInst, boolean direction) {
        flowCheckValidComon(mainInst, direction);
    }

    /**
     * 结算前代码校验 公共方法
     */
    protected void flowCheckValidComon(Instruction mainInst, boolean direction) {

    }

    /**
     * 结算流程过滤
     */
    @Override
    public void settleFlowTypeFilter(LinkedList<TaskFlowService> linked, FlowType flowType, String direction, String trdType) {
        flowTypeFilter(linked, flowType, direction, trdType);
    }

    /**
     * 结算流程过滤方法抽出
     */
    protected void flowTypeFilter(LinkedList<TaskFlowService> linked, FlowType flowType, String direction, String tradeType) {
        System.out.println("默认过滤一下");
    }

}
