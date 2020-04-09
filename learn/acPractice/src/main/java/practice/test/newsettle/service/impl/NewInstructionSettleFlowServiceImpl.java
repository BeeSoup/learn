package practice.test.newsettle.service.impl;

import com.xQuant.platform.app.newsettle.dao.SettleFlowMapper;
import com.xQuant.platform.app.newsettle.entity.settledefine.TaskOperEntity;
import com.xQuant.platform.app.newsettle.service.NewInstructionSettleAppService;
import com.xQuant.platform.app.newsettle.service.NewInstructionSettleFlowService;
import com.xQuant.platform.app.newsettle.service.task.TaskFlowService;
import com.xQuant.platform.app.newsettle.service.task.TaskFlowStepProxy;
import com.xQuant.platform.app.settle.entity.CallResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author yu.zhang
 * @Description: 结算流程定义实现类
 * @date 2019/8/8 14:10
 */
//@Component
public class NewInstructionSettleFlowServiceImpl implements NewInstructionSettleFlowService {

    /**
     * 必备日志一份
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 结算结构Map
     */
    @Resource(name = "settleFlowMap")
    protected Map<String, Map<String, LinkedList<TaskFlowService>>> map;

    /**
     * 结算应用接口
     */
    @Autowired
    private NewInstructionSettleAppService settleAppService;

    @Autowired
    private SettleFlowMapper settleFlowMapper;

    /**
     * @Author yu.zhang
     * @Date 2019/8/8 14:12
     * 经办方法： 包括校验、指令包的创建、结算上下文的创建
     */
    @Override
    public CallResponse lockInstructionOper(Long instId, String operator, String account, String orgCode, boolean isOneStep) {
        System.out.println("经办开始了");

        //查询出来记账等指令，然后直接传入，一次查询，处处使用

        //风险，在操作的时候，别人在编辑券，在撤单    ------有没有必要 速度讲道理应该还行

//        settleAppService.invokeAppMethod("getCall", false, "错误");
//        settleAppService.invokeAppMethod("getCall",new Class[]{boolean.class, String.class},
//                false, "错误");
        Object getOperFlow = settleAppService.invokeAppMethod("NewInstructionSettleAppServiceImpl",
                "getCall", new Class[]{boolean.class, String.class},
                true, "good luck");

        //经办总体校验
        settleAppService.checkVaild(instId);
        //将经办更新为经办结算流程状态，下次进入，无需再总校验
        settleAppService.instructionOperUpdate(instId);
        //经办结算前的校验，用于校验代码结算相关内容
        settleAppService.operCheckVaild(instId, true);
        //创建大对象
        TaskOperEntity obj = settleAppService.buildTaskOper(instId);
        //获取经办的结算流程代理
        TaskFlowStepProxy proxy = settleAppService.getOperFlow(true, null);
        //执行代理
        proxy.work(obj);
        System.out.println("经办OK了");
        return null;
    }

    /**
     * 复核
     */
    @Override
//    @Transactional(propagation = Propagation.NEVER)
    public CallResponse lockInstructionSettle() {
        return null;
    }

    /**
     * 抹经办
     */
    @Override
    public CallResponse lockInstructionOperErase() {
        return null;
    }

    /**
     * 抹复核
     */
    @Override
    public CallResponse lockInstructionSettleErase() {
        return null;
    }

    /**
     * 外汇经办
     */
    @Override
    public CallResponse lockInstructionOper4Fx() {
        return null;
    }

    /**
     * 外汇复核
     */
    @Override
    public CallResponse lockInstructionSettle4Fx() {
        return null;
    }

    /**
     * 抹外汇经办
     */
    @Override
    public CallResponse lockInstructionOperErase4Fx() {
        return null;
    }

    /**
     * 抹外汇复核
     */
    @Override
    public CallResponse lockInstructionSettleErase4Fx() {
        return null;
    }

}
