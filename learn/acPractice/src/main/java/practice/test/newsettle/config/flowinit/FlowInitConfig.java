package practice.test.newsettle.config.flowinit;

import com.xQuant.platform.app.newsettle.config.flowinit.impl.FlowInitImpl;
import com.xQuant.platform.app.newsettle.service.task.TaskFlowService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author yu.zhang
 * @Description: 结算流程配置类
 * @date 2019/9/25 10:19
 */
//@Configuration
public class FlowInitConfig implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Bean(name = "flowInit", initMethod = "flowInit")
    public FlowInitImpl flowInit() {
        //使用Spring启动注册获取就可以了，不用手工注册
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(FlowInitConfig.class);
        FlowInitImpl flowInitImpl = new FlowInitImpl(this.applicationContext);
        return flowInitImpl;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean(name = "settleFlowMap")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @DependsOn(
            value = "flowInit"
    )
    public Map<String, Map<String, LinkedList<TaskFlowService>>> getMap() {
        FlowInitImpl flow = (FlowInitImpl) this.applicationContext.getBean("flowInit");
        if (flow == null) {
            return null;
        }
        try {
            Method getMap = flow.getClass().getDeclaredMethod("getMap");
            getMap.setAccessible(true);
            Map<String, Map<String, LinkedList<TaskFlowService>>> map =
                    (Map<String, Map<String, LinkedList<TaskFlowService>>>) getMap.invoke(flow);
            getMap.setAccessible(false);
            return map;
        } catch (Exception e) {
            return null;
        }
    }
}
