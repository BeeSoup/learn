package practice.design.structrual.decorate;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/7 9:57
 */
public class MilkHerbalJelly extends Decorator {

    public MilkHerbalJelly(HerbalJelly herbalJelly) {
        super(herbalJelly);
    }

    @Override
    public void process() {
        super.process();
        System.out.println("加牛奶");
    }
}
