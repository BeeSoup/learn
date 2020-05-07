package practice.test.newsettle.service.task.action;


import com.xQuant.platform.app.newsettle.entity.settledefine.MethodResponse;
import com.xQuant.platform.app.newsettle.entity.settledefine.TaskOperEntity;
import com.xQuant.platform.app.newsettle.service.task.AbstractTaskFlowAdapterService;
import com.xQuant.platform.app.settle.entity.TaskEntity;
import org.springframework.stereotype.Component;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/9 15:40
 */
@Component("thirdTask")
public class ThirdTask extends AbstractTaskFlowAdapterService {

    public ThirdTask() {
        this.task = "third";
    }

    @Override
    protected MethodResponse doWorkBefore(final TaskOperEntity taskOperEntity) {
        System.out.println("doWorkBefore : " + this.task);
        return MethodResponse.COMPLETE;
    }

    @Override
    protected MethodResponse doWorkAfter(final TaskOperEntity taskOperEntity) {
//        boolean errFlag = taskOperEntity.isFlag();
//        if (errFlag) {
//            throw new RuntimeException("我错了");
//        }
        System.out.println("doWorkAfter : " + this.task);
        return MethodResponse.COMPLETE;
    }

    @Override
    protected MethodResponse doWork(final TaskOperEntity taskOperEntity) {
        System.out.println("doWork : " + this.task);
        return MethodResponse.COMPLETE;
    }

    @Override
    public String getTaskId() {
        return "third";
    }

    @Override
    public String getTaskName(String direction) {
        if (TaskEntity.TASK_ENTITY_DIRECTION_FORWORD.equals(direction)) {
            return "third";
        }
        return "抹third";
    }
}
