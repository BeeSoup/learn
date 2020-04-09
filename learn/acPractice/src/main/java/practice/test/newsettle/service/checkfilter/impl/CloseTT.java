package practice.test.newsettle.service.checkfilter.impl;

import com.xquant.platform.component.itf.cfets.common.remote.receive.SingleThreadMessageConsumer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.Lifecycle;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/9/17 16:00
 */
@Component
public class CloseTT implements SmartLifecycle, ApplicationContextAware {

    @Autowired
    private WebApplicationContext webAppContext;

    private ApplicationContext applicationContext;

    @Autowired
    private List<SmartLifecycle> smartLifecycles;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    //返回false就不执行start方法了
    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable callback) {

    }

    @Override
    public void start() {
        try {
//            SingleThreadMessageConsumer bean = webAppContext.getBean(SingleThreadMessageConsumer.class);
//            AutowireCapableBeanFactory factory = this.applicationContext.getAutowireCapableBeanFactory();
//            Object singleThreadMessageConsumer = factory.getBean("singleThreadMessageConsumer");
//            factory.
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()){
                Thread key = entry.getKey();
                String name = key.getName();
                if (name.indexOf("SingleThreadMessageConsumer-") > -1) {
                    key.interrupt();
                } else if (name.indexOf("CFETS") > -1) {
                    key.interrupt();
                } else if (name.indexOf("CMDS") > -1) {
                    key.interrupt();
                } else if (name.indexOf("POSTTRADE") > -1) {
                    key.interrupt();
                }
            }
//            Field marketDataThread = SingleThreadMessageConsumer.class.getDeclaredField("marketDataThread");
//            marketDataThread.setAccessible(true);
//            for (SmartLifecycle bean : smartLifecycles) {
//                if (bean instanceof SingleThreadMessageConsumer) {
//                    Thread thread = (Thread) marketDataThread.get(bean);
//                    thread.interrupt();
//                }
//            }

            int size = smartLifecycles.size();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    //升序
    @Override
    public int getPhase() {
        return 5000;
    }

}
