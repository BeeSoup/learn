package practice.design.structrual.adapter;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/8 9:06
 */
public class Targer implements Adapter {
    private Charger charger;

    public Targer(Charger charger) {
        this.charger = charger;
    }

    @Override
    public void adapter() {
        System.out.println("适配器");
        this.charger.charge();
    }
}
