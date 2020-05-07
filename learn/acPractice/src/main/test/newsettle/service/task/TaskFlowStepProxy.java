package practice.test.newsettle.service.task;


import com.xQuant.platform.app.newsettle.entity.settledefine.MethodResponse;
import com.xQuant.platform.app.newsettle.entity.settledefine.SettleResponse;
import com.xQuant.platform.app.newsettle.entity.settledefine.TaskOperEntity;

/**
 * @author yu.zhang
 * @Description: 任务代理类，形成任务链式调用
 * @date 2019/8/9 14:20
 */
public class TaskFlowStepProxy implements TaskFlowStep {

    private TaskFlowService current;

    private TaskFlowStepProxy nextProxy;

    public void setCurrent(TaskFlowService current) {
        this.current = current;
    }

    public void setNextProxy(TaskFlowStepProxy nextProxy) {
        this.nextProxy = nextProxy;
    }

    public TaskFlowService getCurrent() {
        return current;
    }

    @Override
    public void work(TaskOperEntity operateObj) {
        current.execute(current, nextProxy, operateObj);
        if (operateObj.getPreMethodResponse().getState() == MethodResponse.COMPLETE.getState()) {
            //下一个任务为空，说明任务结束
            if (nextProxy == null) {
                operateObj.setSettleResponse(SettleResponse.COMPLETE);
                return;
            }
            //下一个任务调用前的前置工作
            current.initNextEntity(operateObj);
            nextProxy.work(operateObj);
        }
    }

}
