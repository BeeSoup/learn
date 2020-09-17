package practice.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射执行方法
 */
public class GetSetReflect {

    private String name;

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

//    public void setAge(String age) {
//        this.age = age;
//    }
    public void setAge(Integer age) {

    }


    public GetSetReflect(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public GetSetReflect() {
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        GetSetReflect entity = new GetSetReflect("zhang", "24");
        String methodName = "name";
        String methodNameL = "nameL";
        //  System.out.println(methodNameL.length());
        System.out.println(methodName.toLowerCase());
        System.out.println(methodNameL.toLowerCase());
        System.out.println(methodNameL.substring(0, 1).toUpperCase() + methodNameL.substring(1));
        System.out.println(methodNameL.substring(1, methodName.length() + 1));

        Field[] fields = GetSetReflect.class.getFields(); //父类以及子类的 公有
        fields = GetSetReflect.class.getDeclaredFields(); //declared 子类 私有以及共有
//        for (Field field : fields) {
//            String name = field.getName();
//            String fieldMethod = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
//
//            Method method = GetSetReflect.class.getMethod(fieldMethod);
//            Object invoke = method.invoke(entity);
//            System.out.println("get" + name + ". value = " + invoke.toString());
//        }
        Method setAge = GetSetReflect.class.getMethod("setAge");
    }
}
