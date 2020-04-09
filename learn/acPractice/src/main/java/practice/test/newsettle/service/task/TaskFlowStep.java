package practice.test.newsettle.service.task;


import com.xQuant.platform.app.newsettle.entity.settledefine.TaskOperEntity;

/**
 * @Author yu.zhang
 * @Description: 任务职能定义接口
 * @Date 2019/9/2 16:30
 */
public interface TaskFlowStep {
    /**
     * 任务步骤Work方法
     */
    public void work(TaskOperEntity obj);


}
