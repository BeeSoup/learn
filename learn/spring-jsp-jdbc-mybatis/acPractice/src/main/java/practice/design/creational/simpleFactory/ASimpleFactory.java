package practice.design.creational.simpleFactory;

/**
* 简单工厂 父类根据参数创建产品
*/
public class ASimpleFactory {
    public static Parent getPrint(Class clazz){
        Parent parent = null;
        try {
            parent = (Parent) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return parent;
    }
}
