package practice.test.newsettle.service.task;

import com.xQuant.platform.app.newsettle.entity.settledefine.TaskInitParam;

/**
 * @Author yu.zhang
 * @Description: 任务属性定义接口
 * @Date 2019/9/2 16:31
 */
public interface TaskService {
    /**
     * 获取任务的Id
     */
    public String getTaskId();

    /**
     * 获取任务的名称 统一使用同一个大对象，包含操作的所有数据
     */
    public String getTaskName(String direction);

    /**
     * 获取任务的自定义参数配置
     */
    public TaskInitParam getParam();

    /**
     * 设置任务的自定义参数配置
     */
    public void setParam(TaskInitParam param);
}
