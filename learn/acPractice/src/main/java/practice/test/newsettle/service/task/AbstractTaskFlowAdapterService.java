package practice.test.newsettle.service.task;

import com.xQuant.platform.app.newsettle.entity.settledefine.MethodResponse;
import com.xQuant.platform.app.newsettle.entity.settledefine.SettleTaskMthod;
import com.xQuant.platform.app.newsettle.entity.settledefine.TaskInitParam;
import com.xQuant.platform.app.newsettle.entity.settledefine.TaskOperEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author yu.zhang
 * @Description: 任务抽象抽象类，给予任务链调用默认实现
 * @date 2019/8/9 14:31
 */
public abstract class AbstractTaskFlowAdapterService implements TaskFlowService, InitializingBean, DisposableBean, ApplicationContextAware {

    /**
     * 必备日志一份
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected ApplicationContext applicationContext;

    protected String task;

    /**
     * 每个任务配置的初始化参数
     */
    protected TaskInitParam param;

    @Override
    public void afterPropertiesSet() throws Exception {
//        System.out.println("初始化这个bean");
    }

    @Override
    public void destroy() throws Exception {
//        System.out.println("销毁一下bean");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void work(TaskOperEntity obj) {
        //  将由代理类来执行Work
    }

    /**
     * 任务链对外执行方法
     */
    @Override
    public void execute(TaskFlowService currenTask, TaskFlowStepProxy nextProxy, TaskOperEntity taskOperEntity) {
        System.out.println("大对象地址 ： " + taskOperEntity);
        //这里将加上日志控制，是否打印大对象
        currenTask.aopExecute(currenTask, taskOperEntity);
    }

    /**
     * 日志AOP方法哟
     */
    @Override
    public TaskOperEntity aopExecute(TaskFlowService currenTask, TaskOperEntity taskOperEntity) {
        return executeMethod(currenTask, taskOperEntity);
    }

    /**
     * 为下一个任务节点给初始化值
     */
    public void initNextEntity(final TaskOperEntity taskOperEntity) {
//          每一次都是重新开始
        taskOperEntity.setCurrentMethod(SettleTaskMthod.UNWORK);
        taskOperEntity.setPreMethodResponse(MethodResponse.BEGIN);
    }

    /**
     * 具体的执行方法哟 已经扩展出一切你想要的
     */
    private TaskOperEntity executeMethod(TaskFlowService currenTask, TaskOperEntity taskOperEntity) {
        System.out.println("大家好，现在执行到了方法为：" + taskOperEntity.getCurrentMethod().name() +
                "   , 上一个方法的返回是 ： " + taskOperEntity.getPreMethodResponse().name());
        if (isQuit(taskOperEntity)) {
            return taskOperEntity;
        }
//      默认什么条件走哪个流程未确定，将通过兼容目前的结算任务来确认
        //before
        if (taskOperEntity.getCurrentMethod().getValue() == SettleTaskMthod.UNWORK.getValue() && andBeforeCondi(taskOperEntity)
                || orBeforeCondi(taskOperEntity)) {
            taskOperEntity.setCurrentMethod(SettleTaskMthod.DOWORKBEFORE);
            MethodResponse response = doWorkBefore(taskOperEntity);
            taskOperEntity.setPreMethodResponse(response);
            //work
        } else if (taskOperEntity.getCurrentMethod().getValue() == SettleTaskMthod.DOWORKBEFORE.getValue() && andWorkCondi(taskOperEntity)
                || orWorkCondi(taskOperEntity)) {
            taskOperEntity.setCurrentMethod(SettleTaskMthod.DOWORK);
            MethodResponse response = doWork(taskOperEntity);
            taskOperEntity.setPreMethodResponse(response);
            //after 执行完以后自动结束该任务节点
        } else if (taskOperEntity.getCurrentMethod().getValue() == SettleTaskMthod.DOWORK.getValue() && andAfterCondi(taskOperEntity)
                || orAfterCondi(taskOperEntity)) {
            taskOperEntity.setCurrentMethod(SettleTaskMthod.DOWORKAFTER);
            MethodResponse response = doWorkAfter(taskOperEntity);
            taskOperEntity.setPreMethodResponse(response);
            return taskOperEntity;
            //加了自定义的判断后，除了无限递归调用before 和 work，预留一个出口
        } else {
            throw new RuntimeException("死循环了,少年,你怕是有点厉害！");
        }
        return executeMethod(currenTask, taskOperEntity);
    }

    /**
     * 任务流工作前方法 前置校验。准备工作。跳过
     */
    protected abstract MethodResponse doWorkBefore(final TaskOperEntity taskOperEntity);

    /**
     * 任务流工作后方法 正经活
     */
    protected abstract MethodResponse doWorkAfter(final TaskOperEntity taskOperEntity);

    /**
     * 任务流工作方法 发送查证 处理、判断（重复执行）
     */
    protected abstract MethodResponse doWork(final TaskOperEntity taskOperEntity);

    /**
     * 不想干了，想退出，重写这个，状态、风险自己把控
     */
    protected boolean isQuit(final TaskOperEntity taskOperEntity) {
        return false;
    }

    /**
     * 自定义判断 ||before，状态、风险自己把控
     */
    protected boolean orBeforeCondi(final TaskOperEntity taskOperEntity) {
        return false;
    }

    /**
     * 自定义判断 ||work，状态、风险自己把控
     */
    protected boolean orWorkCondi(final TaskOperEntity taskOperEntity) {
        return false;
    }

    /**
     * 自定义判断 ||after，状态、风险自己把控
     */
    protected boolean orAfterCondi(final TaskOperEntity taskOperEntity) {
        return false;
    }

    /**
     * 自定义判断 &&before，状态、风险自己把控
     */
    protected boolean andBeforeCondi(final TaskOperEntity taskOperEntity) {
        return true;
    }

    /**
     * 自定义判断 &&work，状态、风险自己把控
     */
    protected boolean andWorkCondi(final TaskOperEntity taskOperEntity) {
        return true;
    }

    /**
     * 自定义判断 &&after，状态、风险自己把控
     */
    protected boolean andAfterCondi(final TaskOperEntity taskOperEntity) {
        return true;
    }

    @Override
    public TaskInitParam getParam() {
        return param;
    }

    @Override
    public void setParam(TaskInitParam param) {
        this.param = param;
    }

}
