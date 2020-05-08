package practice.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 发布和订阅相关
 */
public class Event {


    public static void main(String[] args) {

        //创建上下文
    //    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        //增加监听器
     //   context.addApplicationListener(new MyApplicationListener());
//        context.addApplicationListener(new MyApplicationListener());

        //bean注册
     //   context.register(MyApplicationListener.class);

        //启动上下文
    //    context.refresh();



        //-------------另一种方式

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyApplicationListener.class);
        Data data = new Data("111111这是里是事件",false);

        System.out.println("begin : " + data.isResult());

        context.publishEvent(new MyApplicationEvent(data));

        System.out.println("over : " + data.isResult());


    }



    //自定义监听
//    @Component
    private static class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {


        @Override
        public void onApplicationEvent(MyApplicationEvent event) {
            Data source = (Data) event.getSource();
            System.out.println(source.getMsg());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            source.setResult(true);
        }
    }


    //自定义事件
    private static class MyApplicationEvent extends ApplicationEvent {


        /**
         * Create a new {@code ApplicationEvent}.
         *
         * @param source the object on which the event initially occurred or with
         *               which the event is associated (never {@code null})
         */
        public MyApplicationEvent(Object source) {
            super(source);
        }
    }

    private static class Data {
        String msg;
        boolean result = false;

        public Data(String msg, boolean result) {
            this.msg = msg;
            this.result = result;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public boolean isResult() {
            return result;
        }

        public void setResult(boolean result) {
            this.result = result;
        }
    }

}
