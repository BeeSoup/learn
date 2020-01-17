package practice.design.creational.simpleFactory;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/7/8 16:24
 */
public class MyTest {
    public static void main(String[] args) {
        Parent parent = ASimpleFactory.getPrint(Child01.class);
        if(parent != null) {
            parent.print();
        }
    }
}
