package practice.test.newsettle.service;

import com.xQuant.platform.app.newsettle.entity.settledefine.FlowType;
import com.xQuant.platform.app.newsettle.service.task.TaskFlowService;
import com.xQuant.platform.app.newsettle.service.task.TaskFlowStepProxy;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yu.zhang
 * @Description: 结算流程初始化接口
 * @date 2019/8/21 16:00
 */
public interface InstructionSettleFlowInitWarpper {

//
//    /**
//     * 获取Map 提供副本
//     */
//    public Map<String, Map<String, LinkedList<TaskFlowService>>> getMap();

    /**
     * 返回流程LinedList
     */
    public LinkedList<TaskFlowService> getFlowMap(String flowTypeName, String direction);

    /**
     * 组装任务链
     */
    public List<TaskFlowStepProxy> build(LinkedList<TaskFlowService> list);

    /**
     * 获取代理类 ,并且进行自定义过滤
     */
    public List<TaskFlowStepProxy> getTaskProxy(FlowType flowType, String direction, String trdType);
}
