package practice.test.newsettle.controller;

import com.xQuant.base.exception.MessageCode;
import com.xQuant.base.resource.impl.ResourceMsgServiceImpl;
import com.xQuant.base.response.CommResponse;
import com.xQuant.platform.app.newsettle.aop.PersonService;
import com.xQuant.platform.app.newsettle.dao.SettleFlowMapper;
import com.xQuant.platform.app.newsettle.service.NewInstructionSettleFlowService;
import com.xQuant.platform.app.newsettle.service.task.TaskFlowService;
import com.xquant.platform.component.javascript.curd.facade.FacadeCURDService;
import com.xquant.platform.component.job.service.TtskTriggerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yu.zhang
 * @Description: 新结算Controller
 * @date 2019/8/13 14:27
 */
@Controller
@RequestMapping(value = "NewInstructionSettle")
public class NewInstructionController implements ApplicationContextAware {

    private static Logger logger = LoggerFactory.getLogger(NewInstructionController.class);

    private boolean flag = false;

    private ApplicationContext applicationContext;

//    @Autowired
//    private NewInstructionSettleFlowService settleService;
//
//    @Autowired
//    private PersonService personService;

//    @Autowired
//    @Qualifier("firstTask")
//    private TaskFlowService firstTask;
//
//    @Autowired
//    @Qualifier("secondTask")
//    private TaskFlowService secondTask;
//
//    @Autowired
//    @Qualifier("thirdTask")
//    private TaskFlowService thirdTask;
////
//    @Autowired
//    private ThirdTask thirdTask;

//    @Autowired
//    private SettleFlowMapper settleFlowMapper;

//    @Autowired
//    @Resource(name = "springMyEven")
//    private MyEvenInter myEvenInter;

//    @Autowired
//    private TtskTriggerService ttskTriggerService;


    @RequestMapping(value = "/test.action")
    @ResponseBody
    public String test(@RequestParam("instId") Long instId) {
//        personService.aopsave(flag);
//        personService.outsideSelect(flag);
//        personService.outsideUpdate(flag);
        if (flag) {
            flag = false;
        } else {
            flag = true;
        }

//        Object giveSpringMyEven = this.applicationContext.getBean("springMyEven");
//        String name = myEvenInter.getName();
//        LinkedList<TaskFlowService> flowLink = InstructionSettleFlowInitWarpperImpl.getFlowMap("NormalCreditSettle", "1", "forword");
//        List<TaskFlowStepProxy> build = InstructionSettleFlowInitWarpperImpl.build(flowLink);
//        List<TaskFlowStepProxy> build = instructionSettleFlowInitWarpper.getTaskProxy("NormalCreditSettle", "1", "forword");
//        TaskOperEntity obj = new TaskOperEntity();
//        TaskOperEntity obj = new TaskOperEntity.BuilderEntity().builderBussinessKey("0577")
//                .builderContext(new SettleContext()).builderBussinessKey(instId + "").buildEntity();
//        build.get(0).work(obj);
//        settleService.lockInstructionOper(instId, null, null, null, true);
//        FacadeCURDService curdService = (FacadeCURDService) applicationContext.getBean("curdServiceBeanName");
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("jobName","com.xquant.platform.itf.direct.qssfx.internal.service.sync.sendreq.timerjob.FxSpotTradeSyncReqSendTimerJob");
//        System.out.println("bean名字 ： " + curdService.getClass().toString());
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
//        HttpServletRequest request = servletRequestAttributes.getRequest();
//        curdService.delete(map, request);
//        ttskTriggerService.removeJobAndTrigger("14352");
        return "success";
    }


    @RequestMapping(value = "/test1.action")
    @ResponseBody
    public Object test1() {
        return new CommResponse(true, "text",
                ResourceMsgServiceImpl.getResourceMessage(MessageCode.MESSAGE_SUCCESS));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


//propagation = Propagation.REQUIRES_NEW

//    @RequestMapping(value = "/test2.action")
//    @ResponseBody
//    public String test2() {
//        LinkedList<TaskFlowService> list = new LinkedList<TaskFlowService>();
//        TaskOperEntity obj = new TaskOperEntity();
//        obj.setWorkResponse(WorkResponse.CONTINUE);
//        TaskInitParam param = new TaskInitParam();
//        param.setNeedHandCheck(1);
//        if (firstTask.getParam() != null && firstTask.getParam().getNeedHandCheck() == 1) {
//            param.setNeedHandCheck(2);
//        }
//        firstTask.setParam(param);
////        firstTask.doTest();
//        list.add(firstTask);
//        list.add(secondTask);
//        list.add(thirdTask);
//        List<TaskFlowStepProxy> build = build(list);
//        build.get(0).work(obj);
//        return "success";
//    }

//    public static List<TaskFlowStepProxy> build(LinkedList<TaskFlowService> list) {
//        LinkedList<TaskFlowStepProxy> proxys = new LinkedList<TaskFlowStepProxy>();
//        TaskFlowStepProxy lastProxy = new TaskFlowStepProxy();
//        if (list.size() > 0) {
//            TaskFlowService lastTast = list.removeLast();
//            lastProxy.setCurrent(lastTast);
//            lastProxy.setNextProxy(null);
//            proxys.addFirst(lastProxy);
//        }
//        while (list.size() > 0) {
//            TaskFlowService current = list.removeLast();
//            TaskFlowStepProxy proxy = new TaskFlowStepProxy();
//            proxy.setCurrent(current);
//            proxy.setNextProxy(lastProxy);
//            proxys.addFirst(proxy);
//            lastProxy = proxy;
//        }
//        return proxys;
//    }

}
