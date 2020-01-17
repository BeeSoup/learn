package practice.design.creational.factorymethod;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/7/16 11:17
 */
public class AChildFactory2 extends AFactortyMethod {

    @Override
    public Parent getChild() {
        return new Child02();
    }

}
