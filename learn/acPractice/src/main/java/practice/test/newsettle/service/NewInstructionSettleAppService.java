package practice.test.newsettle.service;

import com.xQuant.platform.app.newsettle.entity.settledefine.FlowType;
import com.xQuant.platform.app.newsettle.entity.settledefine.TaskOperEntity;
import com.xQuant.platform.app.newsettle.service.task.TaskFlowStepProxy;
import com.xQuant.platform.app.settle.entity.CallResponse;
import com.xQuant.platform.app.settle.entity.SettleContext;

/**
 * @Author yu.zhang
 * @Description: 新结算的应用操作接口
 * @Date 2019/8/8 13:58
 */
public interface NewInstructionSettleAppService {
    public final static String BEAN_NAME = "newInstructionSettleAppService";

    /**
     * 锁操作,将通过操作TTRD_TASK_ENTITY 获取状态来判断是否已经获取到了锁
     */
    public CallResponse lockOperator(Integer instId);

    /**
     * 锁操作,将通过操作TTRD_TASK_ENTITY 通过修改状态来操作锁
     */
    public CallResponse unLockOperator(Integer instId);

    /**
     * 总体公共校验
     */
    public CallResponse checkVaild(Long instId);

    /**
     * 经办的状态前置更新 --按流程拆分的话 待经办，经办中，待结算(经办失败) 待经办需要初始化校验，
     * 经办中 校验经办
     */
    public void instructionOperUpdate(Long instId);


    /**
     * 经办流程前校验 代码校验 字段缺失等 经办和抹账公共，通过direction
     * true : 经办
     * false : 抹经办
     */
    public void operCheckVaild(Long instId, boolean direction);


    /**
     * 外汇经办流程前校验 代码校验 字段缺失等 经办和抹账公共，通过direction
     * true : 经办
     * false : 抹经办
     */
    public void operCheckVaildFx(Long instId, boolean direction);


    /**
     * 结算流程前校验 代码校验，通过direction
     * true : 复核
     * false : 抹账
     */
    public void settleCheckVaild(Long instId, boolean direction);

    /**
     * 结算流程前校验 代码校验
     * true : 复核
     * false : 抹账
     */
    public void settleCheckVaildFx(Long instId, boolean direction);

    /**
     * 创建结算上下文
     */
    public SettleContext buildSettleContext();

    /**
     * 创建结算大对象
     */
    public TaskOperEntity buildTaskOper(Long instId);

    /**
     * 获取经办结算流程代理的第一个 走策略过滤
     * true : 正向
     * false : 方向
     */
    public TaskFlowStepProxy getOperFlow(boolean direction, String tradeType);


    /**
     * 获取外汇经办结算流程代理的第一个
     * true : 正向
     * false : 方向
     */
    public TaskFlowStepProxy getOperFlowFx(boolean direction, String tradeType);


    /**
     * 获取复核抹账结算流程代理的第一个
     * true : 正向
     * false : 方向
     */
    public TaskFlowStepProxy getSettleFlow(boolean direction, String tradeType);


    /**
     * 获取外汇复核抹账结算流程代理的第一个
     * true : 正向
     * false : 方向
     */
    public TaskFlowStepProxy getSettleFlowFx(boolean direction, String tradeType);

    /**
     * 获取自定义结算流程 快速版
     * true : 正向
     * false : 方向
     */
    public TaskFlowStepProxy getProxtFlow(FlowType flowType, boolean direction, String tradeType);

    /**
     * 子类自定义方法 获取子类定义的方法
     * 说明：methodName 为方法名，param为参数 该方法不支持基本数据类型 ，默认参数Class为封装类型
     */
    public Object invokeAppMethod(String beanName, String methodName, Object... param);

    /**
     * 子类自定义方法 重载 获取子类定义的方法
     * 说明：methodName 为方法名，对于基本数据类型 传入Class[] Class 传入参数的Class ,param为参数
     * 如：new Class[]{String.class, int.class, String.class}
     */
    public Object invokeAppMethod(String beanName, String methodName, Class[] params, Object... param);

    /**
     * 打印堆栈
     */
    public void printAppMethodLog(String warnMsg, Exception e);


}
