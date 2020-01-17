package practice.design.creational.builder.v2;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/1 17:41
 */
public class Car {
    private String model;
    private String engine;

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", engine='" + engine + '\'' +
                '}';
    }

    public Car(BuilderCar builderCar) {
        this.engine = builderCar.engine;
        this.model = builderCar.model;
    }

    public static class BuilderCar {
        private String model;
        private String engine;

        public BuilderCar builderModel(String model) {
            this.model = model;
            return this;
        }

        public BuilderCar builderEngine(String engine){
            this.engine = engine;
            return this;
        }

        public Car BuilderCar() {
            return new Car(this);
        }
    }
}
