package practice.test.newsettle.service.task.action;


import com.xQuant.platform.app.newsettle.entity.settledefine.MethodResponse;
import com.xQuant.platform.app.newsettle.entity.settledefine.TaskOperEntity;
import com.xQuant.platform.app.newsettle.service.task.AbstractTaskFlowAdapterService;
import com.xQuant.platform.app.settle.entity.TaskEntity;
import org.springframework.stereotype.Component;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/9 15:37
 */
@Component("firstTask")
//@Scope("prototype")
public class FirstTask extends AbstractTaskFlowAdapterService {
    public FirstTask() {
        this.task = "first";
    }

    @Override
    protected MethodResponse doWorkBefore(final TaskOperEntity taskOperEntity) {
        System.out.println("doWorkBefore : " + "first");
        return MethodResponse.COMPLETE;
    }

    @Override
    protected MethodResponse doWorkAfter(final TaskOperEntity taskOperEntity) {
        System.out.println("doWorkAfter : " + "first");
        return MethodResponse.COMPLETE;
    }


    @Override
    protected MethodResponse doWork(final TaskOperEntity taskOperEntity) {
        System.out.println("doWork : " + "first");
        return MethodResponse.COMPLETE;
    }

    @Override
    public String getTaskId() {
        return "first";
    }

    @Override
    public String getTaskName(String direction) {
        if (TaskEntity.TASK_ENTITY_DIRECTION_FORWORD.equals(direction)) {
            return "first";
        }
        return "抹first";
    }
}
