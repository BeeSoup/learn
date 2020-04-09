package practice.test.newsettle.service;

import com.xQuant.base.exception.IRBaseException;
import com.xQuant.platform.app.newsettle.config.flowinit.FlowInit;
import com.xQuant.platform.app.newsettle.dao.SettleFlowMapper;
import com.xQuant.platform.app.newsettle.entity.settledefine.FlowType;
import com.xQuant.platform.app.newsettle.entity.settledefine.TaskOperEntity;
import com.xQuant.platform.app.newsettle.service.checkfilter.SettleCheckFilterServiceWarpper;
import com.xQuant.platform.app.newsettle.service.task.TaskFlowService;
import com.xQuant.platform.app.newsettle.service.task.TaskFlowStepProxy;
import com.xQuant.platform.app.settle.dao.InstructionSettleMapper;
import com.xQuant.platform.app.settle.entity.CallResponse;
import com.xQuant.platform.app.settle.entity.SettleContext;
import com.xQuant.platform.app.settle.entity.TaskEntity;
import com.xQuant.platform.common.tp.entity.CashInstruction;
import com.xQuant.platform.common.tp.entity.Instruction;
import com.xQuant.platform.common.tp.entity.SecuInstruction;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.Resource;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author yu.zhang
 * @Description: 新结算的应用操作定义抽象类
 * @Date 2019/8/8 14:18
 */
public abstract class NewInstructionSettleAppAbstractService implements InitializingBean, NewInstructionSettleAppService, ApplicationContextAware {

    /**
     * 必备日志一份
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 结算结构Map
     */
    @Resource(name = "settleFlowMap")
    protected Map<String, Map<String, LinkedList<TaskFlowService>>> map;

    protected ApplicationContext applicationContext;

    /**
     * 读取数据库后生成的结算流程
     */
//    @Autowired
    private InstructionSettleFlowInitWarpper flowInitWarpper;

    @Resource(name = "flowInit")
    private FlowInit flowInit;

    @Autowired
    private SettleFlowMapper settleFlowMapper;

    @Autowired
    private InstructionSettleMapper instructionSettleMapper;

    @Autowired
    private SettleCheckFilterServiceWarpper checkFilterServiceWarpper;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        map = InstructionSettleFlowInitWarpperImpl.getMap();
        System.out.println(map);
        System.out.println("清空锁，采用update加where 不至于全部再更新一次");
    }

    /**
     * 锁定当前的用户,更新时间戳和状态。只有当前用户操作完成后,调用解锁流程 默认初始化解锁，页面一键解锁
     */
    public CallResponse lockOperator(Integer instId) {
        boolean lock = false;
        CallResponse response = new CallResponse();
        Map<String, Object> mapLock = settleFlowMapper.getLock(instId);//根据instId查询数据库获取到状态 1表示未获取到锁 0 表示 已经有锁 null 表示未有数据插入
//      1 0 如果是0 0 -1 1
        if (mapLock != null && mapLock.size() > 0) {
            Integer state = Integer.valueOf(mapLock.get("STATE").toString());
            if (state == 0) {
//              单独事务
                int updateRow = settleFlowMapper.updateLock(instId);
                if (updateRow == 1) { // 成功更新的情况下，才能获取到锁
                    lock = true;
                }
            }
        } else {
            try {
//              单独事务
                int insertRow = settleFlowMapper.insertLock(instId);
                if (insertRow == 1) { //成功插入的情况才能获取到锁
                    lock = true;
                }
            } catch (Exception e) { // 同时访问，同时插入，只有插入成功的才能获取，如果唯一性报错，当未获取到
                return CallResponse.failure(e.getMessage() + "，异常栈： " + e.getStackTrace());
            }
        }
//        Integer selectState = Math.random() > 0.5 ? 1 : 0;
//        if (selectState == 1) {
//            lock = false;
//        } else if (selectState == 0) {//          更新状态返回更新条数 防止同时查询到0的情况
//            int updateRan = Math.random() > 0.5 ? 1 : 0;//          未更新到，已经有人更新，那么锁应该给已经更新的对象
//            if (updateRan == 0) {
//                lock = false;
//            } else {
//                lock = true;
//            }
//        } else if (selectState == null) {//如果第一次操作(第一次点击经办复核)
//            try {//          插入 通过唯一键和返回条数来控制获取到锁的唯一
//                int insertRan = Math.random() > 0.5 ? 1 : 0;
//                if (insertRan == 1) {
//                    lock = true;
//                } else {
//                    lock = false;
//                }
//            } catch (Exception E) {
//                lock = false;
//            }
//        }
        response.setIsSuccess(lock);
        return response;
    }

    /**
     * 解锁
     */
    public CallResponse unLockOperator(Integer instId) {
//      单独事务
        int unLock = settleFlowMapper.updateUnLock(instId);
        if (unLock != 1) {
            return CallResponse.failure("卧槽，数据没了？");
        }
        return CallResponse.success();
        // update state 1 ->0
    }

    /**
     * 总体的校验方法，包括公共的校验 待经办和抹经办后，需要重新进入 属于业务层面校验
     */
    public CallResponse checkVaild(Long instId) {
        Instruction mainInst = instructionSettleMapper.queryMainInstByInstId(instId);

        if (mainInst == null) {
            return CallResponse.failure("主指令为空");
        }
        List<CashInstruction> cashInstList = instructionSettleMapper.queryCashInstByInstId(instId);
        List<SecuInstruction> secuInstList = instructionSettleMapper.querySecuInstByInstId(instId);
        this.commonCheckVaild(mainInst, cashInstList, secuInstList);
        this.strategyCheckVaild(mainInst, cashInstList, secuInstList);
        return CallResponse.success();
    }

    /**
     * 公共的校验方法
     */
    protected abstract void commonCheckVaild(Instruction mainInst, List<CashInstruction> cashInstList, List<SecuInstruction> secuInstList);

    /**
     * 特殊业务的校验方法 走策略类
     */
    protected void strategyCheckVaild(Instruction mainInst, List<CashInstruction> cashInstList, List<SecuInstruction> secuInstList) {
        checkFilterServiceWarpper.operCheckVaild(mainInst, cashInstList, secuInstList);
    }

    @Override
    public void operCheckVaild(Long instId, boolean direction) {
        Instruction mainInst = instructionSettleMapper.queryMainInstByInstId(instId);
        checkFilterServiceWarpper.operFlowCheckVaild(mainInst, direction);
    }

    @Override
    public void operCheckVaildFx(Long instId, boolean direction) {
        Instruction mainInst = instructionSettleMapper.queryMainInstByInstId(instId);
        checkFilterServiceWarpper.operFlowCheckVaildFx(mainInst, direction);
    }

    @Override
    public void settleCheckVaild(Long instId, boolean direction) {
        Instruction mainInst = instructionSettleMapper.queryMainInstByInstId(instId);
        checkFilterServiceWarpper.settleFlowCheckVaild(mainInst, direction);
    }

    @Override
    public void settleCheckVaildFx(Long instId, boolean direction) {
        Instruction mainInst = instructionSettleMapper.queryMainInstByInstId(instId);
        checkFilterServiceWarpper.settleFlowCheckVaildFx(mainInst, direction);
    }

    /**
     * 创建指令包 创建一个包含结算上下文和流程的大对象，然后结算的使用引用同一个大对象，参数一致性
     * 大对象包含该结算的所有信息，统一处理操作是否必要
     */
    public SettleContext buildSettleContext() {
        SettleContext settleContext = new SettleContext();
        updateSettleContext(settleContext);
        return settleContext;
    }

    /**
     * 创建结算大对象
     */
    public TaskOperEntity buildTaskOper(Long instId) {
        //读取数据库，是否已存大对象，没有，那么创建i

        return new TaskOperEntity.BuilderEntity().builderBussinessKey("0577")
                .builderContext(new SettleContext()).builderBussinessKey(instId + "").buildEntity();
    }

    /**
     * 用于修正Context
     */
    protected void updateSettleContext(final SettleContext settleContext) {

    }

    /**
     * 获取经办结算流程代理的第一个 走策略过滤
     * true : 正向
     * false : 方向
     */
    public TaskFlowStepProxy getOperFlow(boolean direction, String tradeType) {
        return getProxtFlow(FlowType.Oper, direction, tradeType);
    }


    /**
     * 获取外汇经办结算流程代理的第一个
     * true : 正向
     * false : 方向
     */
    public TaskFlowStepProxy getOperFlowFx(boolean direction, String tradeType) {
        return getProxtFlow(FlowType.OperFx, direction, tradeType);
    }


    /**
     * 获取复核抹账结算流程代理的第一个
     * true : 正向
     * false : 方向
     */
    public TaskFlowStepProxy getSettleFlow(boolean direction, String tradeType) {
        return getProxtFlow(FlowType.Settle, direction, tradeType);
    }


    /**
     * 获取外汇复核抹账结算流程代理的第一个
     * true : 正向
     * false : 方向
     */
    public TaskFlowStepProxy getSettleFlowFx(boolean direction, String tradeType) {
        return getProxtFlow(FlowType.SettleFx, direction, tradeType);
    }

    /**
     * 获取自定义结算流程 快速版
     * true : 正向
     * false : 方向
     */
    public TaskFlowStepProxy getProxtFlow(FlowType flowType, boolean direction, String tradeType) {
        List<TaskFlowStepProxy> taskProxy = null;
        if (direction) {
            taskProxy = flowInit.getTaskProxy(flowType,
                    TaskEntity.TASK_ENTITY_DIRECTION_FORWORD, tradeType);
        } else {
            taskProxy = flowInit.getTaskProxy(flowType,
                    TaskEntity.TASK_ENTITY_DIRECTION_BACKWORD, tradeType);
        }
        if (CollectionUtils.isEmpty(taskProxy)) {
            //看看本类里面的未过滤map
            throw new IRBaseException("大兄弟自己检查一下是不是流程没有定义还是被过滤完了");
        }
        return taskProxy.get(0);
    }

    /**
     * 子类自定义方法
     * 说明：methodName 为方法名，param为参数 该方法不支持基本数据类型 ，默认参数Class为封装类型
     */
    public Object invokeAppMethod(String beanName, String methodName, Object... param) {
        Object invoke = null;
        Class<? extends NewInstructionSettleAppAbstractService> clazz = this.getClass();
        Class[] params = null;
        if (param != null && param.length != 0) {
            List<Class> classes = new ArrayList<Class>();
            for (Object obj : param) {
                classes.add(obj.getClass());
            }
            final int size = classes.size();
            params = classes.toArray(new Class[size]);
        }
        try {
//            NewInstructionSettleAppService appServiceClass = clazz.newInstance();
            NewInstructionSettleAppService appServiceClass = (NewInstructionSettleAppService)
                    this.applicationContext.getBean(beanName);
//            Method method = clazz.getMethod(methodName, params);
            //传入参数，获取重载方法 以及私有的方法
            Method method = clazz.getDeclaredMethod(methodName, params);
            method.setAccessible(true);//获取私有权限
            invoke = method.invoke(appServiceClass, param);
        } catch (NoSuchMethodException e) {
            printAppMethodLog("自定义方法执行", e);
            String msg = "结算应用自定义方法【" + methodName + "】未找到 " +
                    "-- 错误信息：" + e.getMessage();
            logger.error(msg);
            throw new IRBaseException(msg);
        } catch (IllegalAccessException e) {
            printAppMethodLog("自定义方法执行", e);
            String msg = "结算应用自定义方法【" + methodName + "】执行有误 " +
                    "-- 错误信息：" + e.getMessage();
            logger.error(msg);
            throw new IRBaseException(msg);
        } catch (InvocationTargetException e) {
            printAppMethodLog("自定义方法执行", e);
            String msg = "结算应用自定义方法【" + methodName + "】执行有误 " +
                    "-- 错误信息：" + e.getMessage();
            logger.error(msg);
            throw new IRBaseException(msg);
        } catch (IllegalArgumentException e) {
            printAppMethodLog("自定义方法执行", e);
            String msg = "结算应用自定义方法【" + methodName + "】执行有误[错误的参数个数或者类型]" +
                    " -- 错误信息：" + e.getMessage();
            logger.error(msg);
            throw new IRBaseException(msg);
        } catch (Exception e) {
            String msg = "结算应用自定义方法【" + methodName + "】执行有误[错误的参数个数或者类型]" +
                    " -- 错误信息：" + e.getMessage();
            logger.error(msg);
            throw new IRBaseException(msg);
        }
        return invoke;
    }

    /**
     * 子类自定义方法 重载
     * 说明：methodName 为方法名，对于基本数据类型 传入Class[] Class 传入参数的Class ,param为参数
     * 如：new Class[]{String.class, int.class, String.class}
     */
    public Object invokeAppMethod(String beanName, String methodName, Class[] params, Object... param) {
        Object invoke = null;
        Class<? extends NewInstructionSettleAppAbstractService> clazz = this.getClass();
        try {
//            NewInstructionSettleAppService appServiceClass = clazz.newInstance();
            NewInstructionSettleAppService appServiceClass = (NewInstructionSettleAppService)
                    this.applicationContext.getBean(beanName);
//            Method method = clazz.getMethod(methodName, params);
            //传入参数，获取重载方法 以及私有的方法
            Method method = clazz.getDeclaredMethod(methodName, params);
            method.setAccessible(true);//获取私有权限
            invoke = method.invoke(appServiceClass, param);
        } catch (NoSuchMethodException e) {
            printAppMethodLog("自定义方法执行", e);
            String msg = "结算应用自定义方法【" + methodName + "】未找到 " +
                    "-- 错误信息：" + e.getMessage();
            logger.error(msg);
            throw new IRBaseException(msg);
        } catch (IllegalAccessException e) {
            printAppMethodLog("自定义方法执行", e);
            String msg = "结算应用自定义方法【" + methodName + "】执行有误 " +
                    "-- 错误信息：" + e.getMessage();
            logger.error(msg);
            throw new IRBaseException(msg);
        } catch (InvocationTargetException e) {
            printAppMethodLog("自定义方法执行", e);
            String msg = "结算应用自定义方法【" + methodName + "】执行有误 " +
                    "-- 错误信息：" + e.getMessage();
            logger.error(msg);
            throw new IRBaseException(msg);
        } catch (IllegalArgumentException e) {
            printAppMethodLog("自定义方法执行", e);
            String msg = "结算应用自定义方法【" + methodName + "】执行有误[错误的参数个数或者类型]" +
                    " -- 错误信息：" + e.getMessage();
            logger.error(msg);
            throw new IRBaseException(msg);
        }
        return invoke;
    }

    /**
     * 打印堆栈信息
     */
    @Override
    public void printAppMethodLog(String warnMsg, Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        String error = e.getMessage();
        try {
            e.printStackTrace(pw);
        } finally {
            pw.close();
        }
        logger.error("错误标题：" + warnMsg + "，错误信息：" + error + "  ，堆栈信息 ： " + sw.toString());
    }
}
