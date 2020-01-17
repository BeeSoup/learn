package practice.design.structrual.decorate;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/7 9:56
 */
public class HoneyHerbalJelly extends Decorator {

    public HoneyHerbalJelly(HerbalJelly herbalJelly) {
        super(herbalJelly);
    }

    @Override
    public void process() {
        super.process();
        System.out.println("加蜂蜜");
    }
}
