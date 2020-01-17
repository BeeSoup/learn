package practice.design.creational.builder;

/**
 * @author yu.zhang
 * @Description: 建造者模式，注重部件构成，且关心顺序
 * @date 2019/8/1 14:28
 */

public class ABuilder {
    private InterfaceBuilder builder;
//  调用建造者来创建车，然后再把返回
    public Car makeCar(String engine, String model) {
        this.builder.buildEngine(engine);
        this.builder.buildModel(model);
        return this.builder.makeCarBuilder();
    }
//  set不用的建造方法
    public void setBuilder(InterfaceBuilder builder) {
        this.builder = builder;
    }

    public ABuilder(InterfaceBuilder builder) {
        this.builder = builder;
    }

    public static void main(String[] args) {
//      实际的建造者
        ActualCarBuilder actuBuild = new ActualCarBuilder();

        ABuilder ab = new ABuilder(actuBuild);
//      每一次的建造对象都应该新建 这一步有必要放在父类的建造者模式下面
        actuBuild.setCar(new Car());
        Car car = ab.makeCar("发动机1号", "模型1号");
        actuBuild.setCar(new Car());
        Car car1 = ab.makeCar("发动机2号",null);
        System.out.println(car.toString());
        System.out.println(car1.toString());
    }
}
