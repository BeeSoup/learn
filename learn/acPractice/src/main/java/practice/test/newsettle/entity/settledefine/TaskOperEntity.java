package practice.test.newsettle.entity.settledefine;

import com.xQuant.platform.app.settle.entity.SettleContext;
import com.xQuant.platform.app.settle.entity.TaskEntity;

/**
 * @author yu.zhang
 * @Description: 结算操作大对象
 * @date 2019/8/13 14:45
 */
public class TaskOperEntity {

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

    public TaskOperEntity() {

    }

    public TaskOperEntity(TaskOperEntityBuilder builderEntity) {
        this.msg = builderEntity.getMsg();
        this.taskEntity = builderEntity.getTaskEntity();
        this.settleResponse = builderEntity.getSettleResponse();
        this.bussinessKey = builderEntity.getBussinessKey();
        this.direction = builderEntity.getDirection();
        this.currentMethod = builderEntity.getCurrentMethod();
        this.preMethodResponse = builderEntity.getPreMethodResponse();
        this.context = builderEntity.getContext();
    }

    public TaskOperEntity(BuilderEntity builderEntity) {
        this.msg = builderEntity.msg;
        this.taskEntity = builderEntity.taskEntity;
        this.settleResponse = builderEntity.settleResponse;
        this.bussinessKey = builderEntity.bussinessKey;
        this.direction = builderEntity.direction;
        this.currentMethod = builderEntity.currentMethod;
        this.preMethodResponse = builderEntity.preMethodResponse;
        this.context = builderEntity.context;
    }

    public TaskEntity getTaskEntity() {
        return taskEntity;
    }

    public void setTaskEntity(TaskEntity taskEntity) {
        this.taskEntity = taskEntity;
    }

    public SettleResponse getSettleResponse() {
        return settleResponse;
    }

    public void setSettleResponse(SettleResponse settleResponse) {
        this.settleResponse = settleResponse;
    }

    public String getBussinessKey() {
        return bussinessKey;
    }

    public void setBussinessKey(String bussinessKey) {
        this.bussinessKey = bussinessKey;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public SettleTaskMthod getCurrentMethod() {
        return currentMethod;
    }

    public void setCurrentMethod(SettleTaskMthod currentMethod) {
        this.currentMethod = currentMethod;
    }

    public MethodResponse getPreMethodResponse() {
        return preMethodResponse;
    }

    public void setPreMethodResponse(MethodResponse preMethodResponse) {
        this.preMethodResponse = preMethodResponse;
    }

    public SettleContext getContext() {
        return context;
    }

    public void setContext(SettleContext context) {
        this.context = context;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @Author yu.zhang
     * @Date 2019/8/20 19:27
     * 大对象建造方法
     */
    public static class BuilderEntity {
        /**
         * 结算实体
         */
        private TaskEntity taskEntity;

        /**
         * 结算状态
         */
        private SettleResponse settleResponse = SettleResponse.CONTINUE;

        /**
         * 指令主键
         */
        private String bussinessKey;

        /**
         * 方向
         */
        private String direction = TaskEntity.TASK_ENTITY_DIRECTION_FORWORD;

        /**
         * 执行到的方法
         */
        private SettleTaskMthod currentMethod = SettleTaskMthod.UNWORK;

        /**
         * 上一个方法的返回的状态
         */
        private MethodResponse preMethodResponse = MethodResponse.BEGIN;

        /**
         * 结算上下文
         */
        private SettleContext context;

        /**
         * 结算错误信息
         */
        private String msg;


        public BuilderEntity builderTaskEntity(TaskEntity taskEntity) {
            this.taskEntity = taskEntity;
            return this;
        }

        public BuilderEntity builderSettleResponse(SettleResponse settleResponse) {
            this.settleResponse = settleResponse;
            return this;
        }

        public BuilderEntity builderBussinessKey(String bussinessKey) {
            this.bussinessKey = bussinessKey;
            return this;
        }

        public BuilderEntity builderDirection(String direction) {
            this.direction = direction;
            return this;
        }

        public BuilderEntity builderCurrentMethod(SettleTaskMthod currentMethod) {
            this.currentMethod = currentMethod;
            return this;
        }

        public BuilderEntity builderPreMethodResponse(MethodResponse preMethodResponse) {
            this.preMethodResponse = preMethodResponse;
            return this;
        }

        public BuilderEntity builderContext(SettleContext context) {
            this.context = context;
            return this;
        }

        public BuilderEntity builderMsg(String msg) {
            this.msg = msg;
            return this;
        }

        public TaskOperEntity buildEntity() {
            return new TaskOperEntity(this);
        }
    }
}
