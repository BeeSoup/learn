package practice.design.creational.builder;

/**
 * @author yu.zhang
 * @Description: 接口或者抽象类，提供建造者的部件建造
 * @date 2019/8/1 14:43
 */
public abstract class InterfaceBuilder {
    //  抽象建造部件引擎
    public abstract void buildEngine(String engine);

    //  抽象建造部件模型
    public abstract void buildModel(String model);

    public abstract Car makeCarBuilder();

}
