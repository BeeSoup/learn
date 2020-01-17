package practice.design.creational.factorymethod;

/**
 * @author yu.zhang
 * @Description: 将创建的方法推迟到子类进行
 * @date 2019/7/16 11:17
 */
public class AChildFactory1 extends AFactortyMethod {

    @Override
    public Parent getChild() {
        return new Child01();
    }

}
