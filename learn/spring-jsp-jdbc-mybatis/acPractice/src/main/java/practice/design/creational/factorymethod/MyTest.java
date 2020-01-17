package practice.design.creational.factorymethod;


/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/7/8 16:24
 */
public class MyTest {
    public static void main(String[] args) {
//        AFactortyMethod factortyMethod = new AChildFactory1();
        ADelegateFactory factory = new ADelegateFactory("AChildFactory2");
        Parent parent = factory.getChild();
        parent.print();
    }
}
