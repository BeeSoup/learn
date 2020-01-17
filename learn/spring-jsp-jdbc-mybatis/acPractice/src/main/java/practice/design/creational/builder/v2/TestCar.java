package practice.design.creational.builder.v2;

import java.util.List;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/1 17:51
 */
public class TestCar {
    public static void main(String[] args) {
        Car car = new Car.BuilderCar().builderEngine("电机v2一号").builderModel("模型v2一号").BuilderCar();
        System.out.println(car.toString());

    }
}
