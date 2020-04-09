package practice.test.newsettle.service.checkfilter;

import com.xQuant.platform.app.newsettle.entity.settledefine.FlowType;
import com.xQuant.platform.app.newsettle.service.task.TaskFlowService;
import com.xQuant.platform.common.tp.entity.CashInstruction;
import com.xQuant.platform.common.tp.entity.Instruction;
import com.xQuant.platform.common.tp.entity.SecuInstruction;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author yu.zhang
 * @Date 2019/8/30 16:01
 * 结算校验以及结算流程过滤等策略服务接口
 */
public interface SettleCheckFilterServiceWarpper {

    /**
     * 经办策略校验
     */
    public void operCheckVaild(Instruction mainInst, List<CashInstruction> cashInstList, List<SecuInstruction> secuInstList);

    /**
     * 经办流程前校验 代码校验 字段缺失等 经办和抹账公共，通过direction
     * true : 经办
     * false : 抹经办
     */
    public void operFlowCheckVaild(Instruction mainInst, boolean direction);


    /**
     * 外汇经办流程前校验 代码校验 字段缺失等 经办和抹账公共，通过direction
     * true : 经办
     * false : 抹经办
     */
    public void operFlowCheckVaildFx(Instruction mainInst, boolean direction);


    /**
     * 结算流程前校验 代码校验，通过direction
     * true : 复核
     * false : 抹账
     */
    public void settleFlowCheckVaild(Instruction mainInst, boolean direction);

    /**
     * 结算流程前校验 代码校验
     * true : 复核
     * false : 抹账
     */
    public void settleFlowCheckVaildFx(Instruction mainInst, boolean direction);

    /**
     * 自定义策略过滤，支持三个维度 结算种类，方向，以及业务类型 由业务类型决定分配的策略类
     */
    public void settleFlowTypeFilter(LinkedList<TaskFlowService> linked, FlowType flowType, String direction, String trdType);
}
