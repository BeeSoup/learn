package practice.test.newsettle.service.task;

import com.xQuant.platform.app.newsettle.entity.settledefine.TaskOperEntity;

/**
 * @Author yu.zhang
 * @Description: 任务定义接口
 * @Date 2019/9/2 16:31
 */
public interface TaskFlowService extends TaskFlowStep, TaskService {
    /**
     * 任务链对外执行方法
     */
    public void execute(TaskFlowService currenTask, TaskFlowStepProxy nextProxy, TaskOperEntity taskOperEntity);

    /**
     * 任务链被Spring AOP代理方法 用于日志记录
     */
    public TaskOperEntity aopExecute(TaskFlowService currenTask, TaskOperEntity taskOperEntity);

    /**
     * 执行下一个调用前的前置工作
     */
    public void initNextEntity(final TaskOperEntity taskOperEntity);

}
