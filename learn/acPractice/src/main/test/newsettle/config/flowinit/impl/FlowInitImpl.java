package practice.test.newsettle.config.flowinit.impl;

import com.xQuant.platform.app.newsettle.config.flowinit.FlowInit;
import com.xQuant.platform.app.newsettle.dao.SettleFlowMapper;
import com.xQuant.platform.app.newsettle.entity.settledefine.FlowType;
import com.xQuant.platform.app.newsettle.entity.settledefine.SettleFlow;
import com.xQuant.platform.app.newsettle.entity.settledefine.TaskInitParam;
import com.xQuant.platform.app.newsettle.service.checkfilter.SettleCheckFilterServiceWarpper;
import com.xQuant.platform.app.newsettle.service.task.TaskFlowService;
import com.xQuant.platform.app.newsettle.service.task.TaskFlowStepProxy;
import com.xQuant.platform.app.newsettle.util.SettleTransSynchUtil;
import com.xQuant.platform.app.settle.entity.TaskEntity;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author yu.zhang
 * @Description: 结算流程初始化默认类
 * @date 2019/8/21 16:00
 */
public class FlowInitImpl implements FlowInit {

    /**
     * 必备日志一份
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private List<TaskFlowService> taskServices;

    @Autowired
    private SettleFlowMapper settleFlowMapper;

    @Autowired
    private SettleCheckFilterServiceWarpper settleCheckFilterServiceWarpper;

    private ApplicationContext applicationContext;

    /**
     * 静态结算Map 存放初始化加载后的Map ,提供副本静态方法
     */
    private static Map<String, Map<String, LinkedList<TaskFlowService>>> map;

    private Map<String, TaskFlowService> taskMap;

    public FlowInitImpl(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * 初始化根据数据库配置加载到spring
     */
    @PostConstruct
    public void flowInit() throws Exception {

//        Map<String, TaskFlowService> beansOfType = this.applicationContext.getBeansOfType(TaskFlowService.class);
//        String[] beanNamesForType = this.applicationContext.getBeanNamesForType(TaskFlowService.class);

        if (taskServices == null) {
            return;
        }

        map = new HashMap<String, Map<String, LinkedList<TaskFlowService>>>();
        taskMap = new HashMap<String, TaskFlowService>();
//      将定义的任务类全部都放入到Map中。
        if (taskServices != null) {
            for (TaskFlowService service : taskServices) {
                taskMap.put(service.getTaskId(), service);
            }
        }
        List<Map<String, String>> flowStepDefines = settleFlowMapper.getFlowStepDefine();
        for (Map<String, String> define : flowStepDefines) {
            String initParam = define.get("FLOW_STEP_INITPARAM");
            TaskInitParam param = SettleTransSynchUtil.jsonToInitParam(initParam);
            String flowStepId = define.get("FLOW_STEP_ID");
            TaskFlowService taskFlowService = taskMap.get(flowStepId);
            taskFlowService.setParam(param);
        }
        List<SettleFlow> settleFlows = settleFlowMapper.selectAllSettleFlow();

        for (SettleFlow flow : settleFlows) {
//          第一层flowType 将根据数据库配置的int值转成枚举类，然后获取name 第二层 正反方向
            Map<String, LinkedList<TaskFlowService>> direMap = new HashMap<String, LinkedList<TaskFlowService>>();
            typeMapDeal(direMap, flow);
            FlowType flowType = flow.getFlowType();
            //在数据库添加的类型未在FlowType枚举里定义，请定义后再使用，注意加上注释谢谢合作
            if (flowType == null) {
                map.put("unDefine", direMap);
            } else {
                map.put(flow.getFlowType().name(), direMap);
            }
        }
    }

    private void typeMapDeal(Map<String, LinkedList<TaskFlowService>> direMap, SettleFlow flow) {
        LinkedList forwordLink = new LinkedList();
        List<String> forwordIds = flow.getSettleFlowStepForword();
        for (String taskId : forwordIds) {
            TaskFlowService taskFlowService = taskMap.get(taskId);
            if (taskFlowService != null) {
                forwordLink.add(taskFlowService);
            }
        }
        direMap.put(TaskEntity.TASK_ENTITY_DIRECTION_FORWORD, forwordLink);

        LinkedList backwordLink = new LinkedList();
        List<String> backwordIds = flow.getSettleFlowStepBackword();
        for (String taskId : backwordIds) {
            TaskFlowService taskFlowService = taskMap.get(taskId);
            if (taskFlowService != null) {
                backwordLink.add(taskFlowService);
            }
        }
        direMap.put(TaskEntity.TASK_ENTITY_DIRECTION_BACKWORD, forwordLink);
    }

    /**
     * 获取Map 提供浅拷贝副本 如果想操作链表请clone一份 以Bean的形式，不推荐使用
     */
    private Map<String, Map<String, LinkedList<TaskFlowService>>> getMap() {
        HashMap<String, Map<String, LinkedList<TaskFlowService>>> getMap =
                (HashMap<String, Map<String, LinkedList<TaskFlowService>>>) map;
        if (map == null) {
            return null;
        }
        return (Map<String, Map<String, LinkedList<TaskFlowService>>>) getMap.clone();
    }

    /**
     * 返回流程LinedList浅拷贝副本
     */
    @Override
    public LinkedList<TaskFlowService> getFlowMap(String flowTypeName, String direction) {
        if (map == null) {
            return null;
        }
        Map<String, LinkedList<TaskFlowService>> flowTypeMap = map.get(flowTypeName);
        if (flowTypeMap == null || flowTypeMap.size() == 0) {
            return null;
        }
        LinkedList<TaskFlowService> taskFlowServices = flowTypeMap.get(direction);
        return (LinkedList<TaskFlowService>) taskFlowServices.clone();
    }

    /**
     * 组装任务链
     */
    @Override
    public List<TaskFlowStepProxy> build(LinkedList<TaskFlowService> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        LinkedList<TaskFlowStepProxy> proxys = new LinkedList<TaskFlowStepProxy>();
        TaskFlowStepProxy lastProxy = new TaskFlowStepProxy();
        if (list.size() > 0) {
            TaskFlowService lastTast = list.removeLast();
            lastProxy.setCurrent(lastTast);
            lastProxy.setNextProxy(null);
            proxys.addFirst(lastProxy);
        }
        while (list.size() > 0) {
            TaskFlowService current = list.removeLast();
            TaskFlowStepProxy proxy = new TaskFlowStepProxy();
            proxy.setCurrent(current);
            proxy.setNextProxy(lastProxy);
            proxys.addFirst(proxy);
            lastProxy = proxy;
        }
        return proxys;
    }

    /**
     * 获取代理类 ,并且进行自定义过滤
     */
    @Override
    public List<TaskFlowStepProxy> getTaskProxy(FlowType flowType, String direction, String trdType) {
        LinkedList<TaskFlowService> flowLink = getFlowMap(flowType.name(), direction);

        if (flowLink == null) {
            return null;
        }
        //      这里再加上自定义的剔除策略
        settleCheckFilterServiceWarpper.settleFlowTypeFilter(flowLink, flowType, direction, trdType);

        List<TaskFlowStepProxy> build = build(flowLink);
        return build;
    }
}

