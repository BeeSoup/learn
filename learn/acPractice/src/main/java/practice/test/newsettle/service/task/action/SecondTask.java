package practice.test.newsettle.service.task.action;


import com.xQuant.platform.app.newsettle.entity.settledefine.MethodResponse;
import com.xQuant.platform.app.newsettle.entity.settledefine.TaskOperEntity;
import com.xQuant.platform.app.newsettle.service.task.AbstractTaskFlowAdapterService;
import com.xQuant.platform.app.settle.entity.TaskEntity;
import org.springframework.stereotype.Component;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/9 15:39
 */
@Component("secondTask")
public class SecondTask extends AbstractTaskFlowAdapterService {

    public SecondTask() {
        this.task = "second";
    }

    @Override
    protected MethodResponse doWorkBefore(final TaskOperEntity taskOperEntity) {
        System.out.println("doWorkBefore : " + "second");
        return MethodResponse.COMPLETE;
    }

    @Override
    protected MethodResponse doWorkAfter(final TaskOperEntity taskOperEntity) {
        System.out.println("doWorkAfter : " + "second");
        return MethodResponse.COMPLETE;
    }

    @Override
    protected MethodResponse doWork(final TaskOperEntity taskOperEntity) {
        System.out.println("doWork : " + "second");
        return MethodResponse.COMPLETE;
    }

    @Override
    public String getTaskId() {
        return "second";
    }

    @Override
    public String getTaskName(String direction) {
        if (TaskEntity.TASK_ENTITY_DIRECTION_FORWORD.equals(direction)) {
            return "second";
        }
        return "抹second";
    }
}
