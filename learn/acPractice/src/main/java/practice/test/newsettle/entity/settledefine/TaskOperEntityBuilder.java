package practice.test.newsettle.entity.settledefine;

import com.xQuant.platform.app.settle.entity.SettleContext;
import com.xQuant.platform.app.settle.entity.TaskEntity;

/**
 * @author yu.zhang
 * @Description: 外部建造
 * @date 2019/8/20 19:28
 */
public class TaskOperEntityBuilder {
    /**
     * 结算实体
     */
    private TaskEntity taskEntity;

    /**
     * 结算状态
     */
    private SettleResponse settleResponse;

    /**
     * 指令主键
     */
    private String bussinessKey;

    /**
     * 方向
     */
    private String direction;

    /**
     * 执行到的方法
     */
    private SettleTaskMthod currentMethod;

    /**
     * 上一个方法的返回的状态
     */
    private MethodResponse preMethodResponse;

    /**
     * 结算上下文
     */
    private SettleContext context;

    /**
     * 结算错误信息
     */
    private String msg;

    public TaskOperEntityBuilder builderTaskEntity(TaskEntity taskEntity) {
        this.taskEntity = taskEntity;
        return this;
    }

    public TaskOperEntityBuilder builderSettleResponse(SettleResponse settleResponse) {
        this.settleResponse = settleResponse;
        return this;
    }

    public TaskOperEntityBuilder builderBussinessKey(String bussinessKey) {
        this.bussinessKey = bussinessKey;
        return this;
    }

    public TaskOperEntityBuilder builderDirection(String direction) {
        this.direction = direction;
        return this;
    }

    public TaskOperEntityBuilder builderCurrentMethod(SettleTaskMthod currentMethod) {
        this.currentMethod = currentMethod;
        return this;
    }

    public TaskOperEntityBuilder builderPreMethodResponse(MethodResponse preMethodResponse) {
        this.preMethodResponse = preMethodResponse;
        return this;
    }

    public TaskOperEntityBuilder builderContext(SettleContext context) {
        this.context = context;
        return this;
    }

    public TaskOperEntityBuilder builderMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public TaskOperEntity builderEntity() {
        return new TaskOperEntity(this);
    }

    public TaskEntity getTaskEntity() {
        return taskEntity;
    }

    public SettleResponse getSettleResponse() {
        return settleResponse;
    }

    public String getBussinessKey() {
        return bussinessKey;
    }

    public String getDirection() {
        return direction;
    }

    public SettleTaskMthod getCurrentMethod() {
        return currentMethod;
    }

    public MethodResponse getPreMethodResponse() {
        return preMethodResponse;
    }

    public SettleContext getContext() {
        return context;
    }

    public String getMsg() {
        return msg;
    }
}