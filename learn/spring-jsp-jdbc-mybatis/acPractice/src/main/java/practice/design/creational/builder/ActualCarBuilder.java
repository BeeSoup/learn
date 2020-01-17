package practice.design.creational.builder;

/**
 * @author yu.zhang
 * @Description: 真实的建造者
 * @date 2019/8/1 14:51
 */
public class ActualCarBuilder extends InterfaceBuilder {

    private Car car = new Car();

    @Override
    public void buildEngine(String engine) {
        this.car.setEngine(engine);
    }

    @Override
    public void buildModel(String model) {
        this.car.setModel(model);
    }

    @Override
    public Car makeCarBuilder() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
