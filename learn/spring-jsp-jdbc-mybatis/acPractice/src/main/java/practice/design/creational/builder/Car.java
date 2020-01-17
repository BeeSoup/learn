package practice.design.creational.builder;

/**
 * @author yu.zhang
 * @Description: car
 * @date 2019/8/1 14:47
 */
public class Car {
    private String model;
    private String engine;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", engine='" + engine + '\'' +
                '}';
    }
}
