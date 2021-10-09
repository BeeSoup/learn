package practice.test.newsettle.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.lang.reflect.Method;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/13 20:10
 */
@Aspect
//@Component
public class MyAspectT {
    @Pointcut("@annotation(com.xQuant.platform.app.newsettle.annotation.TAdviceAnnotation)")
    public void controllerAspect() {
        System.out.println("切点");
    }

    /*
     * @Author yu.zhang
     * @Date 2019/8/14 9:47
     * 前置通知（Before advice）
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("=====前置通知开始=====");
    }

    @AfterThrowing(value = "controllerAspect()", throwing = "e")
    public void doAfter(JoinPoint joinPoint, Exception e) {
        System.out.println("=====异常通知开始=====");
    }

    @AfterReturning(pointcut = "controllerAspect()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("=====后置通知开始=====");
    }

    @Around("controllerAspect()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        Object proceed = null;
        System.out.println("=====环绕通知开始=====");
        try {
            proceed = joinPoint.proceed();
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    public void join(JoinPoint joinPoint) {
        try {
            // 获取目标方法的签名
            String signature = joinPoint.getSignature().toString();
            // 再通过得到调用方法的目标对象，从而获取它的类名
            // 根据的带的签名去截取方法名
            // 在目标方法的签名当中以最后一个点加1开始，以包裹参数的第一个尖括号结尾截取方法名
            String methodName = signature.substring(signature.lastIndexOf(".") + 1, signature.indexOf("("));
            String classType = joinPoint.getTarget().getClass().getName();
            // 再通过反射来得到这个类对象
            Class<?> clazz = Class.forName(classType);
            // 得到它内部所有的方法
            Method[] methods = clazz.getDeclaredMethods();
            System.out.println("methodName: " + methodName);
            // 对得到的方法集合进行变脸
            for (Method method : methods) {
                if (method.isAnnotationPresent(TAdviceAnnotation.class) && method.getName().equals(methodName)) {
                    // 这个时候就可以通过这个方法去获取其上面的注解
                    // 我们将获取主借注解的功能封装成一个方法，将之前反射得到的类对象当作参数传递过去
                    String clazzName = clazz.getName();
                    System.out.println("clazzName: " + clazzName + ", methodName: " + methodName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
