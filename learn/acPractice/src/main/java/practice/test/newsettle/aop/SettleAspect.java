package practice.test.newsettle.aop;

import com.xQuant.platform.app.newsettle.entity.settledefine.TaskOperEntity;
import com.xQuant.platform.app.newsettle.service.NewInstructionSettleAppService;
import com.xQuant.platform.app.newsettle.service.task.TaskFlowService;
import com.xQuant.platform.app.newsettle.util.SettleTransSynchUtil;
import com.xQuant.platform.app.settle.entity.CallResponse;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yu.zhang
 * 代理结算AOP 日志处理
 * @Description: @Before  在切点方法之前执行
 * @After 在切点方法之后执行
 * @AfterReturning 切点方法返回后执行
 * @AfterThrowing 切点方法抛异常执行
 * @Around 属于环绕增强，能控制切点执行前，执行后，，用这个注解后，程序抛异常，会影响@AfterThrowing这个注解
 * @date 2019/8/14 10:18
 */
//@Aspect
//@Component
public class SettleAspect {


//    private final String POINT_CUT_1 = "execution (* com.xQuant.platform.app.newsettle.aop.PersonServiceImpl.*(..))";

//    private final String POINT_CUT_2 = "execution (* com.xQuant.platform.app.newsettle.service.task.action.*Task.doWork*(..))";

//    private final String POINT_CUT_3 = "execution (* com.xQuant.platform.app.newsettle.service.task.action.FirstTask.*(..))";

//    private final String POINT_CUT_4 = "execution(* com.xQuant.platform.app.newsettle.service.task.action.*Task.execute(..))";
//    @Pointcut(POINT_CUT_2)
//    private void anyMethod() {} // 声明一个切入点，anyMethod为切入点名称
//
//    @Pointcut(POINT_CUT_4)
//    private void executeMethod() {} // execute切入点，executeMethod为切入点名称

//    @Pointcut("execution (* com.xQuant.platform.app.newsettle.service.task.action.FirstTask.doWorkAfter(..))")
//    private void firstMethod() {} // 声明一个切入点，anyMethod为切入点名称


    //    // 声明该方法是一个前置通知：在目标方法开始之前执行
//    @Before("anyMethod()")
//    public void doAccessCheck(JoinPoint joinPoint) {
//        System.out.println("前置通知");
//    }
//    // 声明该方法是一个前置通知：在目标方法开始之前执行
//    @AfterReturning("executeMethod()")
//    public void doAccessAfter(JoinPoint joinPoint) {
//        System.out.println("execute后置通知");
//    }
//
//    @AfterThrowing(value = "anyMethod()", throwing = "e")
//    public void doAccessCheckException(JoinPoint joinPoint, Exception e) {
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("=====异常通知开始====="+ methodName +"exception :"+e);
//    }
//
//    // 声明该方法是一个前置通知：在目标方法开始之前执行
//    @Before("firstMethod()")
//    public void doFirst(JoinPoint joinPoint) {
//        System.out.println("first前置通知");
//    }


//    @Before("anyMethod()")
//    public void doAnyMethod(JoinPoint joinPoint) {
//        System.out.println("anyMethod前置通知");
//    }

//    @Before("executeMethod()")
////    public void doExecuteMethod(JoinPoint joinPoint) {
////        System.out.println("executeMethod前置通知");
////    }
//    @Before("firstMethod()")
//    public void doFirstMethod(JoinPoint joinPoint) {
//        System.out.println("firstMethod前置通知");
//    }

    /****************************************   测试部分  ***********************************/

    @Pointcut("execution (* com.xQuant.platform.app.newsettle.aop.PersonServiceImpl.aop*(..))")
    private void personMethod() {
    } // 声明一个切入点，anyMethod为切入点名称

    // 声明该方法是一个前置通知：在目标方法开始之前执行
//    @Before("personMethod()")
//    public void doPersonMethod(JoinPoint joinPoint) {
//        System.out.println("personMethod前置通知");
//    }

    @Before(value = "execution (* com.xQuant.platform.app.newsettle.aop.PersonServiceImpl.aop*(..))")
    public void doPersonMethod(JoinPoint joinPoint) {
        System.out.println("personMethod前置通知");
    }

    // 声明该方法是一个前置通知：在目标方法开始之前执行
    @After("personMethod()")
    public void doAccessAfter() {
        System.out.println("personMethod后置通知");
    }


    /**
     * 后置返回
     * 如果第一个参数为JoinPoint，则第二个参数为返回值的信息
     * 如果第一个参数不为JoinPoint，则第一个参数为returning中对应的参数
     * returning：限定了只有目标方法返回值与通知方法参数类型匹配时才能执行后置返回通知，否则不执行，
     * 参数为Object类型将匹配任何目标返回值
     */
    @AfterReturning(value = "execution (* com.xQuant.platform.app.newsettle.aop.PersonServiceImpl.aop*(..))", returning = "result")
    public void doAccessAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("personMethod后置通知返回");
    }

    /**
     * 后置异常通知
     * 定义一个名字，该名字用于匹配通知实现方法的一个参数名，当目标方法抛出异常返回后，将把目标方法抛出的异常传给通知方法；
     * throwing:限定了只有目标方法抛出的异常与通知方法相应参数异常类型时才能执行后置异常通知，否则不执行，
     * 对于throwing对应的通知方法参数为Throwable类型将匹配任何异常。
     *
     * @param joinPoint
     * @param exception
     */
    @AfterThrowing(value = "execution (* com.xQuant.platform.app.newsettle.aop.PersonServiceImpl.aop*(..))", throwing = "exception")
    public void doAfterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
        if (exception instanceof NullPointerException) {
            System.out.println("发生了空指针异常!!!!!");
        }
        System.out.println("personMethod后置异常通知返回");
    }

    /**
     * 环绕通知：
     * 注意:Spring AOP的环绕通知会影响到AfterThrowing通知的运行,不要同时使用
     * <p>
     * 环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值。
     * 环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     */

    @Around(value = "execution (* com.xQuant.platform.app.newsettle.aop.PersonServiceImpl.aop*(..))")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("@Around环绕通知：" + proceedingJoinPoint.getSignature().toString());
        Object obj = null;
        try {
            obj = proceedingJoinPoint.proceed(); //可以加参数
            System.out.println(obj.toString());
        } catch (Throwable throwable) {
            System.out.println("@Around  " + throwable.getMessage() + "异常了异常了 夭寿了   ");
        }
        System.out.println("@Around环绕通知执行结束");
        return obj;
    }

    /**
     * : @Around环绕通知
     * : @Before通知执行
     * : @Before通知执行结束
     * : @Around环绕通知执行结束
     * : @After后置通知执行了!
     * : @AfterReturning
     * 可以使用&&、||、!、三种运算符来组合切点表达式，表示与或非的关系。
     *
     * @Around(value = "pointcut1() || pointcut2()")
     */
    public void explain() {

    }

    /*************************************   正经测试没开玩笑   *************************************/

    /**
     * 必备日志一份
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NewInstructionSettleAppService newInstructionSettleAppService;

    @Around(value = "execution (* com.xQuant.platform.app.newsettle.service.task.AbstractTaskFlowAdapterService+.aopExecute(..))")
    public Object doAroundAdviceTask(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕开始");
//        StringBuffer insertLog = new StringBuffer();
        Object obj = null;
        TaskOperEntity param = null;
        TaskFlowService target = (TaskFlowService) proceedingJoinPoint.getTarget();
        String taskName = null;
        try {
            Object[] args = proceedingJoinPoint.getArgs();
            if (args.length > 1) {
                if (args[1] instanceof TaskOperEntity) {
                    param = (TaskOperEntity) args[1];
                    taskName = target.getTaskName(param.getDirection());
                } else {
                    throw new RuntimeException("别动我的参数");
                }
            }
            obj = proceedingJoinPoint.proceed(); //可以加参数
        } catch (Throwable throwable) {
//            System.out.println("@Around  " + throwable.getMessage() + "异常了异常了 夭寿了   ");
            param.setMsg(throwable.getMessage());
            taskName = target.getTaskName(param.getDirection());
            printLog(param, taskName);
            throw throwable;
        }
        if (obj != null) {
            param = (TaskOperEntity) obj;
            printLog(param, taskName);
            System.out.println("AOP 获得大对象地址" + obj);
        }
        System.out.println("环绕结束");
        return obj;
    }
//    @AfterThrowing(value = "execution (* com.xQuant.platform.app.newsettle.service.task.AbstractTaskFlowAdapterService+.execute(..))", throwing = "exception")
//    public void doAfterThrowingAdviceTask(JoinPoint joinPoint, Throwable exception) {
//        System.out.println("我报错了！真的。 " + exception.getMessage());
//    }

//    @Before(value = "execution (* com.xQuant.platform.app.newsettle.service.task.AbstractTaskFlowAdapterService+.aopExecute(..))")
//    public void doPersonMethodTask(JoinPoint joinPoint) {
//        System.out.println("doPersonMethodTask前置通知");
//    }

//    @After(value = "execution (* com.xQuant.platform.app.newsettle.service.task.AbstractTaskFlowAdapterService+.aopExecute(..))")
//    public void doAccessAfterTask() {
//        System.out.println("doAccessAfterTask后置通知");
//    }


    public void printLog(TaskOperEntity entity, String taskName) {
        SettleTransSynchUtil.synchOperEntiry(entity);
        if (StringUtils.isNotBlank(entity.getMsg())) {
            System.out.println("这是一行日志【步骤名称 ： " + taskName + " ,  结果： " + entity.getMsg() + "】");
            return;
        }
        if (entity.getSettleResponse().getValue() == 0) {
            System.out.println("这是一行日志【步骤名称 ： " + taskName + " ,  结果： " + "完成】");
            return;
        } else if (entity.getSettleResponse().getValue() == 40) {
            System.out.println("这是一行日志【步骤名称 ： " + taskName + " ,  结果： " + "其实我是跳过不打印，就给你看看】");
            return;
        }
    }


    @Around(value = "execution (* com.xQuant.platform.app.newsettle.service.NewInstructionSettleFlowService.lockInstruction*(..))")
    public Object doAroundAdviceSettle(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object obj = null;
        System.out.println("锁一下");
        Object[] args = proceedingJoinPoint.getArgs();
        Object arg = args[0];
        proceedingJoinPoint.getSignature();
        if (arg instanceof Integer) {
            System.out.println("参数名称： " + arg);
        }
        CallResponse response = newInstructionSettleAppService.lockOperator(Integer.valueOf(arg.toString()));
        boolean lock = response.getIsSuccess();
        try {
            if (lock) {
                obj = proceedingJoinPoint.proceed(); //可以加参数
            }
        } catch (Throwable throwable) {
            if (lock) {
                System.out.println("解锁");
                newInstructionSettleAppService.unLockOperator(Integer.valueOf(arg.toString()));
            }
            throw throwable;
        }
        if (lock) {
            System.out.println("解锁");
            newInstructionSettleAppService.unLockOperator(Integer.valueOf(arg.toString()));
        } else {
            System.out.println("瞎点啥呀，别人在处理");
        }
        return obj;
    }
}
